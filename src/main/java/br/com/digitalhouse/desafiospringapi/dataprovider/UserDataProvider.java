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
        if (this.userRepository.isUserFollowingSeller(request.getUserId(), request.getSellerId()))
            throw new DataIntegrityException("This seller is already being followed by you");
        this.follow(request);
    }

    private void follow(UserRequest request) {
        var user = this.findUserById(request.getUserId());
        var userFollow = this.findSellerByUserId(request.getSellerId());
        user.addNewFollow(userFollow);
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

    @Override
    public User getAllUsersFollowSeller(Integer userId) {
        var data = this.findSellerByUserId(userId);

        return UserMapper.fromUserData(data);
    }

    @Override
    public void unfollowSeller(UserRequest request) {
        var user = this.findUserById(request.getUserId());

        boolean isFollower = user.getFollowed().stream().anyMatch(f -> {
            if (f.getUserId() == request.getSellerId()) {
                user.getFollowed().remove(f);
                return true;
            }
            return false;
        });

        if (!isFollower)
            throw new ObjectNotFoundException("This seller not is followed by you");
        this.userRepository.save(user);
    }

}
