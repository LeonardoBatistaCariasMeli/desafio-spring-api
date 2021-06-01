package br.com.digitalhouse.desafiospringapi.configuration.service;

import br.com.digitalhouse.desafiospringapi.dataprovider.UserDataProvider;
import br.com.digitalhouse.desafiospringapi.dataprovider.repository.ProductRepository;
import br.com.digitalhouse.desafiospringapi.dataprovider.repository.UserRepository;
import br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity.ProductData;
import br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity.UserData;
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
        UserData seller1 = new UserData(null, "Carolina", TypeUser.SELLER, new ArrayList<>(),new ArrayList<>(), new ArrayList<>());
        UserData seller2 = new UserData(null, "Nycolas", TypeUser.SELLER, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        this.userRepository.saveAll(Arrays.asList(seller1, seller2));
        seller1.setUserId(1);
        seller2.setUserId(2);

        UserData user1 = new UserData(null, "Leonardo", TypeUser.BUYER, Arrays.asList(seller1, seller2), new ArrayList<>(), new ArrayList<>());
        UserData user2 = new UserData(null, "Gustavo", TypeUser.BUYER, Arrays.asList(seller1), new ArrayList<>(), new ArrayList<>());
        UserData user3 = new UserData(null, "Onias", TypeUser.BUYER, Arrays.asList(seller2), new ArrayList<>(), new ArrayList<>());
        this.userRepository.saveAll(Arrays.asList(user1, user2, user3));

        var product1 = new ProductData(null, "Produto", 1, "Marca", "Azul", "Produto novo");
        this.productRepository.save(product1);
    }
}