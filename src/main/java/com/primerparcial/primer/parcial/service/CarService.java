package com.primerparcial.primer.parcial.service;

import com.primerparcial.primer.parcial.model.Car;

import java.util.List;

public interface CarService {

    Boolean createCar(Car car);
    Car getCar(Long id);
    List<Car> getAllCars();
}
