package com.primerparcial.primer.parcial.service;

import com.primerparcial.primer.parcial.dto.CarDTO;
import com.primerparcial.primer.parcial.model.Car;

import java.util.List;

public interface RestCarService {
    CarDTO getByid(Long id);
    List<CarDTO> getAllCars();
    CarDTO saveCar(Long id);

}
