package com.primerparcial.primer.parcial.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.primerparcial.primer.parcial.dto.CarDTO;
import com.primerparcial.primer.parcial.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/cars/")
public class RestCarController {

    private final RestCarService restCarService;

    @GetMapping(value = "/{id}")
    public ResponseEntity getCar(@PathVariable Long id) throws JsonProcessingException {
        return new ResponseEntity(restCarService.getById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<CarDTO>> getAllCars() throws JsonProcessingException {
        return new ResponseEntity(restCarService.getAllCars(), HttpStatus.OK);
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity saveCar(@PathVariable Long id) throws JsonProcessingException {
        return new ResponseEntity(restCarService.saveCar(id), HttpStatus.ACCEPTED);
    }
}
