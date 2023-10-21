package kodlamaio.rentACar.business.concretes;

import kodlamaio.rentACar.business.abstracts.UserService;
import kodlamaio.rentACar.business.requests.users.CreateUserRequest;
import kodlamaio.rentACar.business.requests.users.UpdateUserRequest;
import kodlamaio.rentACar.business.responses.users.GetAllUsersResponse;
import kodlamaio.rentACar.business.responses.users.GetByIdUsersResponse;
import kodlamaio.rentACar.business.security.PasswordEncoderService;
import kodlamaio.rentACar.core.utilities.mappers.ModelMapperService;
import kodlamaio.rentACar.dataAccess.abstracts.UserRepository;
import kodlamaio.rentACar.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserManager implements UserService {

    private UserRepository userRepository;
    private ModelMapperService modelMapperService;
    private PasswordEncoderService passwordEncoderService;

    @Override
    public List<GetAllUsersResponse> getAll() {
        List<User> users = userRepository.findAll();
        List<GetAllUsersResponse> responses = users.stream().map(
                user -> this.modelMapperService.forResponse().map(
                        user, GetAllUsersResponse.class)).collect(Collectors.toList());
        return responses;
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
        String encodedPassword = passwordEncoderService.encodePassword(user.getPassword());
        user.setId(0);
        user.setPassword(encodedPassword);
        this.userRepository.save(user);
    }

    @Override
    public void update(UpdateUserRequest updateUserRequest) {
        User user = this.modelMapperService.forRequest().map(updateUserRequest, User.class);
        this.userRepository.save(user);
    }

    @Override
    public void delete(int id) {
        this.userRepository.deleteById(id);
    }
}
