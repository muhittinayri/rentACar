package kodlamaio.rentACar.business.abstracts;

import kodlamaio.rentACar.business.requests.users.CreateUserRequest;
import kodlamaio.rentACar.business.requests.users.UpdateUserRequest;
import kodlamaio.rentACar.business.responses.users.GetAllUsersResponse;
import kodlamaio.rentACar.business.responses.users.GetByIdUsersResponse;

import java.util.List;

public interface UserService {
    List<GetAllUsersResponse> getAll();
    GetByIdUsersResponse getById(int id);
    void add(CreateUserRequest createUserRequest);
    void update(UpdateUserRequest updateUserRequest);
    void delete(int id);
}
