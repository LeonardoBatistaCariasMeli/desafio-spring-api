package br.com.digitalhouse.desafiospringapi.configuration.service;

import br.com.digitalhouse.desafiospringapi.dataprovider.repository.*;
import br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity.*;
import br.com.digitalhouse.desafiospringapi.domain.entity.enums.TypeUser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class DBService {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public DBService(UserRepository userRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    public void InstantiateH2Database() {
        var product1 = new ProductData(null, "Cadeira", 1, "Marca", "Azul", "Produto novo");
        this.productRepository.save(product1);

        var product2 = new ProductData(null, "Mesa", 1, "Marca", "Verde", "Produto novo");
        this.productRepository.save(product2);

        var seller = new SellerData(null, "Leonardo", TypeUser.SELLER, new ArrayList<>(), new ArrayList<>(), Arrays.asList(product1, product2), new ArrayList<>());
        this.userRepository.save(seller);
        seller.setUserId(1);

        var seller2 = new SellerData(null, "Nycolas", TypeUser.SELLER, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        this.userRepository.save(seller2);

        var seller3 = new SellerData(null, "Carolina", TypeUser.SELLER, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        this.userRepository.save(seller3);



        var customer = new CustomerData(null, "Onias", TypeUser.BUYER, Arrays.asList(seller));
        this.userRepository.save(customer);

        var customer2 = new CustomerData(null, "Gustavo", TypeUser.BUYER, new ArrayList<>());
        this.userRepository.save(customer2);
    }
}