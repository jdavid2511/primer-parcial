package com.primerparcial.primer.parcial.service;

import com.primerparcial.primer.parcial.model.Car;
import com.primerparcial.primer.parcial.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImp implements CarService{

    private final CarRepository carRepository;

    @Override
    public Boolean createCar(Car car){
        try {
            Car carSave = carRepository.save(car);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Car getCar(Long id){
        return carRepository.findById(id).get();
    }

    @Override
    public List<Car> getAllCars(){
        return carRepository.findAll();
    }
}
