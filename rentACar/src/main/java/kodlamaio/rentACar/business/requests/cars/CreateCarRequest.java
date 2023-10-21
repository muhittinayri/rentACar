package kodlamaio.rentACar.business.requests.cars;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {

    @NotNull
    private String plate;

    @NotNull
    private double dailyPrice;

    @NotNull
    private int modelYear;

    @NotNull
    private int state;

    @NotNull
    private int modelId;

}
