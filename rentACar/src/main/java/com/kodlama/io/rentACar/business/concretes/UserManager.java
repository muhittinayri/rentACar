package com.kodlama.io.rentACar.business.concretes;

import com.kodlama.io.rentACar.business.abstracts.UserService;
import com.kodlama.io.rentACar.business.requests.users.CreateUserRequest;
import com.kodlama.io.rentACar.business.requests.users.UpdateUserRequest;
import com.kodlama.io.rentACar.business.responses.users.GetAllUsersResponse;
import com.kodlama.io.rentACar.business.responses.users.GetByIdUsersResponse;
import com.kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import com.kodlama.io.rentACar.dataAccess.abstracts.UserRepository;
import com.kodlama.io.rentACar.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private UserRepository userRepository;
    private ModelMapperService modelMapperService;
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public List<GetAllUsersResponse> getAll() {
        List<User> users = userRepository.findAll();
        List<GetAllUsersResponse> usersResponse = users.stream().map
                (user -> this.modelMapperService.forResponse()
                .map(user, GetAllUsersResponse.class)).collect(Collectors.toList());
        return usersResponse;
    }

    @Override
    public GetByIdUsersResponse getById(int id) {
        User user = this.userRepository.findById(id).orElseThrow();
        GetByIdUsersResponse response = this.modelMapperService.forResponse().map(user, GetByIdUsersResponse.class);
        return response;
    }

    @Override
    public void add(CreateUserRequest createUserRequest) {
        User user = this.modelMapperService.forRequest().map(createUserRequest, User.class);
        user.setId(0);
        user.setUserName(createUserRequest.getUserName());
        String encodedPassword = passwordEncoder.encode(createUserRequest.getPassword());
        user.setPassword(encodedPassword);
        this.userRepository.save(user);
    }

    @Override
    public void update(UpdateUserRequest updateUserRequest) {
        User user = this.modelMapperService.forRequest().map(updateUserRequest, User.class);
        user.setUserName(updateUserRequest.getUserName());
        String encodedPassword = passwordEncoder.encode(updateUserRequest.getPassword());
        user.setPassword(encodedPassword);
        this.userRepository.save(user);
    }

    @Override
    public void delete(int id) {
        this.userRepository.deleteById(id);
    }
}
