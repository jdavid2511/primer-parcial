package com.primerparcial.primer.parcial.repository;


import com.primerparcial.primer.parcial.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
