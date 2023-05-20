package com.primerparcial.primer.parcial.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.primerparcial.primer.parcial.dto.CarDTO;
import com.primerparcial.primer.parcial.service.RestCarServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/cars/")
public class RestCarController {

    private final RestCarServiceImp restCarServiceImp;

    @GetMapping(value = "/{id}")
    public ResponseEntity getCar(@PathVariable Long id) throws JsonProcessingException {
        return new ResponseEntity(restCarServiceImp.getById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<CarDTO>> getAllCars() throws JsonProcessingException {
        return new ResponseEntity(restCarServiceImp.getAllCars(), HttpStatus.OK);
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity saveCar(@PathVariable Long id) throws JsonProcessingException {
        return new ResponseEntity(restCarServiceImp.saveCar(id), HttpStatus.ACCEPTED);
    }
}
