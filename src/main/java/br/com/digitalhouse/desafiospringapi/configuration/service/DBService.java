package br.com.digitalhouse.desafiospringapi.configuration.service;

import br.com.digitalhouse.desafiospringapi.dataprovider.repository.PostRepository;
import br.com.digitalhouse.desafiospringapi.dataprovider.repository.ProductRepository;
import br.com.digitalhouse.desafiospringapi.dataprovider.repository.UserRepository;
import br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity.CustomerData;
import br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity.PostData;
import br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity.ProductData;
import br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity.SellerData;
import br.com.digitalhouse.desafiospringapi.domain.entity.enums.TypeUser;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        var seller2 = new SellerData(null, "Nycolas", TypeUser.SELLER);
        var seller3 = new SellerData(null, "Carolina", TypeUser.SELLER);
        this.userRepository.saveAll(Arrays.asList(seller, seller2, seller3));

        var product1 = new ProductData(null, "Cadeira DX Racer", 1, "DX Racer", "Vermelho e Preto", "Cadeira gamer top do mercado", seller);
        var product2 = new ProductData(null, "Mesa de escritório", 2, "Tok Stok", "Marrom", "Mesa de escritório nova e de muita qualidade", seller);
        var product3 = new ProductData(null, "Teclado Apple Magic", 3, "Apple", "Prata e Branco", "Teclado bluetooth Apple Magic QWERTY inglês", seller2);
        var product4 = new ProductData(null, "Mouse Apple Magic 2", 3, "Apple", "Cinza Espacial", "Mouse tátil recarregável Apple Magic 2", seller2);
        var product5 = new ProductData(null, "Fone de ouvido Apple In-ear sem fio", 3, "Apple", "Branco", "Fone de ouvido In-ear sem fio Apple AirPods with charging case (2nd generation)", seller2);
        var product6 = new ProductData(null, "Headset HyperX", 1, "HyperX", "Preto e Vermelho", "Headset HyperX Stinger", seller3);
        var product7 = new ProductData(null, "Mouse Pad HyperX", 1, "HyperX", "Preto e Vermelho", "Mouse Pad HyperX 60x60", seller3);
        var product8 = new ProductData(null, "Mouse HyperX 16000 DPI", 1, "HyperX", "Preto e Vermelho", "Mouse HyperX 16000 DPI", seller3);
        this.productRepository.saveAll(Arrays.asList(product1, product2, product3, product4, product5, product6, product7, product8));

        var customer = new CustomerData(null, "Onias", TypeUser.BUYER);
        customer = this.userRepository.save(customer);
        customer.addNewFollow(seller2);
        this.userRepository.save(customer);

        var customer2 = new CustomerData(null, "Gustavo", TypeUser.BUYER);
        customer2 = this.userRepository.save(customer2);
        customer2.addNewFollow(seller);
        this.userRepository.save(customer2);

        var customer3 = new CustomerData(null, "Victor", TypeUser.BUYER);
        customer3 = this.userRepository.save(customer3);
        customer3.addNewFollow(seller3);
        this.userRepository.save(customer3);

        var post = new PostData(null, LocalDate.now(), 1, 1600.00, product1, seller, false, null);
        var post2 = new PostData(null, LocalDate.now(), 2, 400.00, product2, seller, true, 0.25);
        var post3 = new PostData(null, LocalDate.now(), 3, 1500.00, product3, seller2, false, null);
        var post4 = new PostData(null, LocalDate.now(), 4, 800.00, product4, seller2, true, 0.10);
        var post5 = new PostData(null, LocalDate.now(), 5, 80.00, product6, seller3, false, null);
        var post6 = new PostData(null, LocalDate.now(), 6, 350.00, product7, seller3, true, 0.15);

        this.postRepository.saveAll(Arrays.asList(post, post2, post3, post4, post5, post6));
    }
}