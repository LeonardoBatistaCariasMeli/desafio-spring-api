package br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity;

import br.com.digitalhouse.desafiospringapi.domain.entity.enums.TypeUser;

import javax.persistence.Entity;
import java.util.List;

@Entity(name = "CUSTOMER")
public class CustomerData extends UserData {

    public CustomerData() {
    }

    public CustomerData(Integer userId, String name, TypeUser typeUser, List<UserData> followed) {
        super(userId, name, typeUser, followed);
    }
}
