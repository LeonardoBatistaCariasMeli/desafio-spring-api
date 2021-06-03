package br.com.digitalhouse.desafiospringapi.dataprovider;

import br.com.digitalhouse.desafiospringapi.dataprovider.repository.PostRepository;
import br.com.digitalhouse.desafiospringapi.dataprovider.repository.ProductRepository;
import br.com.digitalhouse.desafiospringapi.dataprovider.repository.UserRepository;
import br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity.PostData;
import br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity.ProductData;
import br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity.UserData;
import br.com.digitalhouse.desafiospringapi.domain.entity.Post;
import br.com.digitalhouse.desafiospringapi.domain.entity.mapper.PostMapper;
import br.com.digitalhouse.desafiospringapi.domain.gateways.PostGateway;
import br.com.digitalhouse.desafiospringapi.exceptions.DataIntegrityException;
import br.com.digitalhouse.desafiospringapi.exceptions.ObjectNotFoundException;
import br.com.digitalhouse.desafiospringapi.usecase.model.request.PostRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PostDataProvider implements PostGateway {

    private final PostRepository postRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public PostDataProvider(PostRepository postRepository, ProductRepository productRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void registerNewPost(PostRequest request) {
        var post = this.assemblePostDataOf(request);
        post = this.postRepository.save(post);

        if (post.getPostId() == null)
            throw new DataIntegrityException("The post was not created");
    }

    private PostData assemblePostDataOf(PostRequest request) {
        var product = this.getProductById(request);
        var user = this.getUserById(request.getUserId());
        var hasPromo = request.getHasPromo() == null ? false : true;
        return new PostData(null, request.getDate(), request.getCategory(), request.getPrice(), product, user, hasPromo, request.getDiscount());
    }

    private ProductData getProductById(PostRequest request) {
        var product = this.productRepository.findByProductIdAndUserUserId(request.getDetail().getProductId(), request.getUserId());

        if (product == null)
            throw new ObjectNotFoundException("The user does not have this product");
        return product;
    }

    private UserData getUserById(Integer userId) {
        var user = this.userRepository.findById(userId);
        return user.get();
    }

    @Override
    public List<Post> getAllPostsByUserIdOnLastTwoWeeks(Integer userId) {
        var user = this.getUserById(userId);
        var now = LocalDate.now();
        var twoWeeksAgo = now.minusWeeks(2);
        var posts = this.postRepository.getAllPostsByUserIdOnLastTwoWeeks(twoWeeksAgo, now, userId);

        if (posts == null || posts.isEmpty()) {
            throw new ObjectNotFoundException("This seller don't hava any post");
        }

        return PostMapper.fromListPostData(posts);
    }
}