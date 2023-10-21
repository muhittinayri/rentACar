package kodlamaio.rentACar.business.requests.brands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBrandRequest {

    @NotNull
    private int id;

    @NotNull
    private String name;
}
