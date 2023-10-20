package com.kodlama.io.rentACar.business.abstracts;

import com.kodlama.io.rentACar.business.requests.users.CreateUserRequest;
import com.kodlama.io.rentACar.business.requests.users.UpdateUserRequest;
import com.kodlama.io.rentACar.business.responses.users.GetAllUsersResponse;
import com.kodlama.io.rentACar.business.responses.users.GetByIdUsersResponse;

import java.util.List;

public interface UserService {
    List<GetAllUsersResponse> getAll();
    GetByIdUsersResponse getById(int id);
    void add(CreateUserRequest createUserRequest);
    void update(UpdateUserRequest updateUserRequest);
    void delete(int id);
}
