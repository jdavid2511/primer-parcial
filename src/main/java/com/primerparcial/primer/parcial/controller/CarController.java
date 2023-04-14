package com.primerparcial.primer.parcial.controller;

import com.primerparcial.primer.parcial.model.Car;
import com.primerparcial.primer.parcial.service.CarServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class CarController {

    @Autowired
    private final CarServiceImp carServiceImp;

    @PostMapping(value = "/car")
    public ResponseEntity saveCar(@RequestBody Car car){
        Map response = new HashMap();
        Boolean carResp = carServiceImp.createCar(car);

        if (carResp == true) {
            response.put("status","201");
            response.put("massage","se creo el vehiculo");
            return new ResponseEntity(response, HttpStatus.ACCEPTED);
        }
        response.put("status","400");
        response.put("massege","Hubo un error al crear el vehiculo");
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/car/{id}")
    public ResponseEntity getCar(@PathVariable Long id){
        Map response = new HashMap();
        try{
            return new ResponseEntity(carServiceImp.getCar(id), HttpStatus.OK);
        }catch (Exception e){
            response.put("status","404");
            response.put("message","nese encontro el vehiculo");
            return new ResponseEntity(response, HttpStatus.MULTI_STATUS);
        }
    }

    @GetMapping(value = "/cars")
    public ResponseEntity<List> getAllCars(){
        Map response = new HashMap();
        try{
            return new ResponseEntity (carServiceImp.getAllCars(), HttpStatus.OK);
        }catch (Exception e){
            response.put("status","404");
            response.put("message","nese encontro el vehiculo");
            return new ResponseEntity(response, HttpStatus.MULTI_STATUS);
     }
   }
}
