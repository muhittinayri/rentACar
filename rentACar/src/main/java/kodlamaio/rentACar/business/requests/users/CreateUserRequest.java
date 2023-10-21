package kodlamaio.rentACar.business.requests.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private int carId;
}
