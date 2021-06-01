package br.com.digitalhouse.desafiospringapi.dataprovider;

import br.com.digitalhouse.desafiospringapi.dataprovider.repository.UserRepository;
import br.com.digitalhouse.desafiospringapi.dataprovider.repository.entity.UserData;
import br.com.digitalhouse.desafiospringapi.domain.entity.User;
import br.com.digitalhouse.desafiospringapi.domain.entity.enums.TypeUser;
import br.com.digitalhouse.desafiospringapi.domain.entity.mapper.UserMapper;
import br.com.digitalhouse.desafiospringapi.domain.gateways.UserGateway;
import br.com.digitalhouse.desafiospringapi.exceptions.DataIntegrityException;
import br.com.digitalhouse.desafiospringapi.exceptions.ObjectNotFoundException;
import br.com.digitalhouse.desafiospringapi.usecase.model.request.UserRequest;
import org.springframework.stereotype.Service;

@Service
public class UserDataProvider implements UserGateway {

    private final UserRepository userRepository;

    public UserDataProvider(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Integer userId) {
        var user = this.findUserById(userId);
        return UserMapper.fromUserData(user);
    }

    private UserData findUserById(Integer userId) {
        var user = this.userRepository.findById(userId);

        if (user.isEmpty())
            throw new ObjectNotFoundException("The user not exists. Id: " + userId);

        return user.get();
    }

    @Override
    public void followNewSeller(UserRequest request) {
        if(this.userRepository.isUserFollowingSeller(request.getUserId(), request.getUserIdSeller()))
            throw new DataIntegrityException("This seller is already being followed by you");

        var user = this.findUserById(request.getUserId());
        var seller = this.findSellerById(request.getUserIdSeller());
        user.addNewSeller(seller);
        this.userRepository.save(user);
    }

    private UserData findSellerById(Integer sellerId) {
        var seller = this.userRepository.findByUserIdAndTypeUser(sellerId, TypeUser.SELLER.getCode());
        if (seller.isEmpty())
            throw new ObjectNotFoundException("The seller not exists. Id: " + sellerId);

        if(!(seller.get().getTypeUser() == TypeUser.SELLER.getCode())) {
            throw new DataIntegrityException("This user don't is a seller. Id: " + sellerId);
        }

        return seller.get();
    }

    @Override
    public User getQuantityUsersFollowSeller(Integer userId) {
        var seller = this.findSellerById(userId);
        var followers = this.userRepository.getQuantityUsersFollowSeller(userId);

        return UserMapper.fromUserData(seller, followers);
    }
}
