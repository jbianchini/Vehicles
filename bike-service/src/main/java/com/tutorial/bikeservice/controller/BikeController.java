package com.tutorial.bikeservice.controller;

import com.tutorial.bikeservice.entity.Bike;
import com.tutorial.bikeservice.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bike")
public class BikeController {

    @Autowired
    BikeService bikeService;

    @GetMapping
    public ResponseEntity<List<Bike>> getAllBikes() {
        List<Bike> bikes = bikeService.getAll();
        if(bikes.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(bikes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bike> getById(@PathVariable("id") Long id) {
        Bike bike = bikeService.getBikeById(id);
        if(bike == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(bike);
    }

    @PostMapping
    public ResponseEntity<Bike> save(@RequestBody Bike bike) {
        Bike newBike = bikeService.save(bike);
        return ResponseEntity.ok(newBike);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Bike>> getAllByUserId(@PathVariable("userId") Long userId) {
        List<Bike> bikes = bikeService.getAllByUserId(userId);
        if(bikes.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(bikes);
    }
}
