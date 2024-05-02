package com.tutorial.carservice.controller;

import com.tutorial.carservice.entity.Car;
import com.tutorial.carservice.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> cars = carService.getAll();
        if(cars.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getById(@PathVariable("id") Long id) {
        Car car = carService.getCarById(id);
        if(car == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(car);
    }

    @PostMapping
    public ResponseEntity<Car> save(@RequestBody Car car) {
        Car newCar = carService.save(car);
        return ResponseEntity.ok(newCar);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Car>> getAllByUserId(@PathVariable("userId") Long userId) {
        List<Car> cars = carService.getAllByUserId(userId);
        if(cars.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(cars);
    }
}
