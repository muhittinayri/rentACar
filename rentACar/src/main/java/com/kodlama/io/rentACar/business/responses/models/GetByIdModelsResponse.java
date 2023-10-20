package com.kodlama.io.rentACar.business.responses.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdModelsResponse {
    private int id;
    private String name;
    private String brandName;
}