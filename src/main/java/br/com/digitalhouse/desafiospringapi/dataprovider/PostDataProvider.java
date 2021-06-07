package br.com.digitalhouse.desafiospringapi.dataprovider;

import br.com.digitalhouse.desafiospringapi.dataprovider.repository.PostRepository;
import br.com.digitalhouse.desafiospringapi.dataprovider.repository.ProductRepository;
import br.com.digitalhouse.desafiospringapi.dataprovider.repository.UserRepository;
import br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity.PostData;
import br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity.ProductData;
import br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity.UserData;
import br.com.digitalhouse.desafiospringapi.domain.entity.Post;
import br.com.digitalhouse.desafiospringapi.domain.entity.enums.TypeUser;
import br.com.digitalhouse.desafiospringapi.domain.entity.mapper.PostMapper;
import br.com.digitalhouse.desafiospringapi.domain.gateways.PostGateway;
import br.com.digitalhouse.desafiospringapi.exceptions.DataIntegrityException;
import br.com.digitalhouse.desafiospringapi.exceptions.ObjectNotFoundException;
import br.com.digitalhouse.desafiospringapi.usecase.model.request.PostRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostDataProvider implements PostGateway {

    private final PostRepository postRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final UserDataProvider userDataProvider;

    public PostDataProvider(PostRepository postRepository, ProductRepository productRepository, UserRepository userRepository, UserDataProvider userDataProvider) {
        this.postRepository = postRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.userDataProvider = userDataProvider;
    }

    @Override
    public void registerNewPost(PostRequest request) {
        var post = this.assemblePostDataOf(request);
        post = this.postRepository.save(post);

        if (post.getPostId() == null)
            throw new DataIntegrityException("The post was not created");
    }

    private PostData assemblePostDataOf(PostRequest request) {
        var user = this.getSeller(request.getUserId());
        var product = this.getProductById(request);
        var hasPromo = request.getHasPromo() == null ? false : true;
        return new PostData(null, request.getDate(), request.getCategory(), request.getPrice(), product, user, hasPromo, request.getDiscount());
    }

    private ProductData getProductById(PostRequest request) {
        var product = this.productRepository.findByProductIdAndUserUserId(request.getDetail().getProductId(), request.getUserId());

        if (product == null)
            throw new ObjectNotFoundException("The user does not have this product");
        return product;
    }

    private UserData getSeller(Integer userId) {
        var user = this.userRepository.findByUserIdAndTypeUser(userId, TypeUser.SELLER.getCode());

        if (user.isEmpty())
            throw new ObjectNotFoundException("This seller not exists.");
        return user.get();
    }

    @Override
    public List<Post> getAllPostsOfSellersFollowedByUserIdOnLastTwoWeeks(Integer userId) {
        var user = this.getUserById(userId);

        var posts = new ArrayList<PostData>();
        user.getFollowed().stream().forEach(f -> {
            var p = this.findPostsOnLastTwoWeeks(f.getUserId());
            posts.addAll(p);
        });

        if (posts.isEmpty())
            throw new ObjectNotFoundException("The sellers if your follow don't have any post on last two weeks");

        return PostMapper.fromListPostData(posts);
    }

    private UserData getUserById(Integer userId) {
        var user = this.userRepository.findById(userId);

        if (user.isEmpty())
            throw new ObjectNotFoundException("This user not exists.");
        return user.get();
    }

    private List<PostData> findPostsOnLastTwoWeeks(Integer userId) {
        var now = LocalDate.now();
        var twoWeeksAgo = now.minusWeeks(2);
        return this.postRepository.getAllPostsOfSellersFollowedByUserIdOnLastTwoWeeks(twoWeeksAgo, now, userId);
    }

    @Override
    public List<Post> getAllPromoPostsByUserId(Integer userId) {
        this.userDataProvider.findSellerByUserId(userId);
        var posts = this.postRepository.findByHasPromoAndUserUserId(true, userId);
        if (posts == null || posts.isEmpty())
            throw new ObjectNotFoundException("This seller don't have any post");
        return PostMapper.fromListPostData(posts);
    }
}