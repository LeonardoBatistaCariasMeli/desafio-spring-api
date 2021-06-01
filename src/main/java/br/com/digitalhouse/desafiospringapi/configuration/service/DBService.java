package br.com.digitalhouse.desafiospringapi.configuration.service;

import br.com.digitalhouse.desafiospringapi.dataprovider.repository.UserRepository;
import br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity.UserData;
import br.com.digitalhouse.desafiospringapi.domain.entity.enums.TypeUser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class DBService {
    private final UserRepository userRepository;

    public DBService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void InstantiateH2Database() {
        UserData seller1 = new UserData(null, "Carolina", TypeUser.SELLER, new ArrayList<>());
        UserData seller2 = new UserData(null, "Nycolas", TypeUser.SELLER, new ArrayList<>());
        this.userRepository.saveAll(Arrays.asList(seller1, seller2));
        seller1.setUserId(1);
        seller2.setUserId(2);

        UserData user1 = new UserData(null, "Leonardo", TypeUser.BUYER, Arrays.asList(seller1, seller2));
        UserData user2 = new UserData(null, "Gustavo", TypeUser.BUYER, Arrays.asList(seller1));
        UserData user3 = new UserData(null, "Onias", TypeUser.BUYER, Arrays.asList(seller2));

        this.userRepository.saveAll(Arrays.asList(user1, user2, user3));
    }
}