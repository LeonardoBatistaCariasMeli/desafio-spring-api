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
        if (this.userRepository.isUserFollowingSeller(request.getUserId(), request.getUserIdSeller()))
            throw new DataIntegrityException("This seller is already being followed by you");

        this.follow(request);
    }

    private void follow(UserRequest request) {
        var user = this.findUserById(request.getUserId());
        var seller = this.findSellerByUserId(request.getUserIdSeller());
        this.isBothSellers(user.getTypeUser(), seller.getTypeUser());
        user.addNewFollow(seller);
        this.userRepository.save(user);
    }

    private UserData findSellerByUserId(Integer userId) {
        var user = this.userRepository.findByUserIdAndTypeUser(userId, TypeUser.SELLER.getCode());
        if (user.isEmpty())
            throw new ObjectNotFoundException("The seller not exists. Id: " + userId);
        if (!(user.get().getTypeUser() == TypeUser.SELLER.getCode()))
            throw new DataIntegrityException("This user don't is a seller. Id: " + userId);
        return user.get();
    }

    private void isBothSellers(Integer typeUserCode1, Integer typeUserCode2) {
        if(typeUserCode1 == typeUserCode2)
            throw new DataIntegrityException("Both users are sellers");
    }

    @Override
    public User getQuantityUsersFollowSeller(Integer userId) {
        var seller = this.findSellerByUserId(userId);
        var followers = this.userRepository.getQuantityUsersFollowSeller(userId);

        return UserMapper.fromUserData(seller, followers);
    }

    @Override
    public User getAllUsersFollowSeller(Integer userId) {
        var user = this.findSellerByUserId(userId);

        return UserMapper.fromUserData(user);
    }

    @Override
    public User getAllSellersThatAnUserFollow(Integer userId) {
        var user = this.findUserById(userId);

        return UserMapper.fromUserData(user);
    }
}
