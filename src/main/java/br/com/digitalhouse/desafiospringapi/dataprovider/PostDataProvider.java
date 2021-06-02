package br.com.digitalhouse.desafiospringapi.dataprovider;

import br.com.digitalhouse.desafiospringapi.dataprovider.repository.PostRepository;
import br.com.digitalhouse.desafiospringapi.dataprovider.repository.ProductRepository;
import br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity.PostData;
import br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity.ProductData;
import br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity.UserData;
import br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity.mapper.UserDataMapper;
import br.com.digitalhouse.desafiospringapi.domain.entity.enums.TypeUser;
import br.com.digitalhouse.desafiospringapi.domain.gateways.PostGateway;
import br.com.digitalhouse.desafiospringapi.exceptions.DataIntegrityException;
import br.com.digitalhouse.desafiospringapi.exceptions.ObjectNotFoundException;
import br.com.digitalhouse.desafiospringapi.usecase.model.request.PostRequest;
import br.com.digitalhouse.desafiospringapi.usecase.model.request.ProductRequest;
import org.springframework.stereotype.Service;

@Service
public class PostDataProvider implements PostGateway {

    private final PostRepository postRepository;
    private final ProductRepository productRepository;
    private final UserDataProvider userDataProvider;

    public PostDataProvider(PostRepository postRepository, ProductRepository productRepository, UserDataProvider userDataProvider) {
        this.postRepository = postRepository;
        this.productRepository = productRepository;
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
        var product = this.getProductById(request.getDetail());
        var user = this.getUserById(request.getUserId());
        return new PostData(null, request.getCategory(), request.getPrice(), product, user);
    }

    private ProductData getProductById(ProductRequest request) {
        var product = this.productRepository.findById(request.getProductId());
        return product.orElseThrow(() -> new ObjectNotFoundException("This product not exists. Id:" + request.getProductId()));
    }

    private UserData getUserById(Integer userId) {
        var user = this.userDataProvider.getUserById(userId);
        if (!user.getTypeUser().equals(TypeUser.SELLER))
            throw new DataIntegrityException("This user can't create a post!");
        return UserDataMapper.fromUser(user);
    }
}