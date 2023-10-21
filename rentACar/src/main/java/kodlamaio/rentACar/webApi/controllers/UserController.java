package kodlamaio.rentACar.webApi.controllers;

import kodlamaio.rentACar.business.abstracts.UserService;
import kodlamaio.rentACar.business.requests.users.CreateUserRequest;
import kodlamaio.rentACar.business.requests.users.UpdateUserRequest;
import kodlamaio.rentACar.business.responses.users.GetAllUsersResponse;
import kodlamaio.rentACar.business.responses.users.GetByIdUsersResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @GetMapping
    public List<GetAllUsersResponse> getAll(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdUsersResponse getById(@PathVariable() int id){
        return userService.getById(id);
    }

    @PostMapping(value = "/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid()CreateUserRequest createUserRequest){
        this.userService.add(createUserRequest);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody()UpdateUserRequest updateUserRequest){
        this.userService.update(updateUserRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable() int id){
        this.userService.delete(id);
    }
}
