package com.kodlama.io.rentACar.webApi.controllers;

import com.kodlama.io.rentACar.business.abstracts.UserService;

import com.kodlama.io.rentACar.business.requests.users.CreateUserRequest;
import com.kodlama.io.rentACar.business.requests.users.UpdateUserRequest;
import com.kodlama.io.rentACar.business.responses.users.GetAllUsersResponse;
import com.kodlama.io.rentACar.business.responses.users.GetByIdUsersResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @GetMapping()
    public List<GetAllUsersResponse> getAll(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdUsersResponse GetById(@PathVariable() int id){
        return userService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid() CreateUserRequest createUserRequest){
        this.userService.add(createUserRequest);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody()UpdateUserRequest updateCarRequest){
        this.userService.update(updateCarRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable() int id){
        this.userService.delete(id);
    }
}
