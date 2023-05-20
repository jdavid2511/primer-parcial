package com.primerparcial.primer.parcial.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {
    Long id;
    String car;
    String car_model;
    String car_color;
    String car_model_year;
    String car_vin;
    String price;
    String availability;
}
