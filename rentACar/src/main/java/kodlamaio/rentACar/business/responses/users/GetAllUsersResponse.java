package kodlamaio.rentACar.business.responses.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllUsersResponse {
    private String firstName;
    private String lastName;
    private String userName;
}
