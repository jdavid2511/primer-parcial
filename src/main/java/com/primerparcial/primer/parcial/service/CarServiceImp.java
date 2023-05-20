package com.primerparcial.primer.parcial.service;

import com.primerparcial.primer.parcial.model.Car;
import com.primerparcial.primer.parcial.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.GetMapping;


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


    @Override

    public Car getCar(Long id){
        return carRepository.findById(id).get();
    }

    @Override
    public List<Car> getAllCars(){
        return carRepository.findAll();
    }


    @Override
    public Boolean updateCar(Car car, Long id){
        try {
            Car carBD = carRepository.findById(id).get();
            if(carBD == null){
                return false;
            }
            carBD.setCar(car.getCar());
            carBD.setCar_model(car.getCar_model());
            carBD.setCar_color(car.getCar_color());
            carBD.setCar_model_year(car.getCar_model_year());
            carBD.setCar_vin(car.getCar_vin());
            carBD.setPrice(car.getPrice());
            carBD.setAvailability(car.getAvailability());
            Car carUp = carRepository.save(carBD);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Boolean deleteCar(Long id, Car car) {
        try {
            Car carDB = carRepository.findById(id).get();
            if (carDB == null){
                return false;
            }
            carRepository.delete(carDB);
            return true;
        }catch (Exception e){
            return false;
        }
    }


}
