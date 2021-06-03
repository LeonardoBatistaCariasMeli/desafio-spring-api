package br.com.digitalhouse.desafiospringapi.configuration.service;

import br.com.digitalhouse.desafiospringapi.dataprovider.repository.*;
import br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity.*;
import br.com.digitalhouse.desafiospringapi.domain.entity.Post;
import br.com.digitalhouse.desafiospringapi.domain.entity.enums.TypeUser;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

@Service
public class DBService {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final PostRepository postRepository;

    public DBService(UserRepository userRepository, ProductRepository productRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.postRepository = postRepository;
    }

    public void InstantiateH2Database() {
        var seller = new SellerData(null, "Leonardo", TypeUser.SELLER);
        seller = this.userRepository.save(seller);

        var product1 = new ProductData(null, "Cadeira", 1, "Marca", "Azul", "Produto novo", seller);
        var product2 = new ProductData(null, "Mesa", 1, "Marca", "Verde", "Produto novo", seller);
        this.productRepository.saveAll(Arrays.asList(product1, product2));

        var seller2 = new SellerData(null, "Nycolas", TypeUser.SELLER);
        this.userRepository.save(seller2);

        var seller3 = new SellerData(null, "Carolina", TypeUser.SELLER);
        this.userRepository.save(seller3);

        var customer = new CustomerData(null, "Onias", TypeUser.BUYER);
        var customer2 = new CustomerData(null, "Gustavo", TypeUser.BUYER);
        this.userRepository.saveAll(Arrays.asList(customer, customer2));

        var post = new PostData(null, LocalDate.now(), 50, 1000.00, product2, seller);
        this.postRepository.save(post);
    }
}