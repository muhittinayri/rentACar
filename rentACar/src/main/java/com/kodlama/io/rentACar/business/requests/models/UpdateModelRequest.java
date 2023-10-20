package com.kodlama.io.rentACar.business.requests.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateModelRequest {
    private int id;
    private String name;
    private int brandId;
    private int userId;
}
