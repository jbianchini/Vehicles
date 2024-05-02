package com.tutorial.userservice.controller;

import com.tutorial.userservice.entity.User;
import com.tutorial.userservice.modelos.Bike;
import com.tutorial.userservice.modelos.Car;
import com.tutorial.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAll();
        if(users.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") Long id) {
        User user = userService.getUserById(id);
        if(user == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        User newUser = userService.save(user);
        return ResponseEntity.ok(newUser);
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity<List<Car>> getCars(@PathVariable("id") Long id) {
        User user = userService.getUserById(id);
        if(user == null)
            return ResponseEntity.notFound().build();
        List<Car> cars = userService.getCars(id);
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/bikes/{id}")
    public ResponseEntity<List<Bike>> getBikes(@PathVariable("id") Long id) {
        User user = userService.getUserById(id);
        if(user == null)
            return ResponseEntity.notFound().build();
        List<Bike> bikes = userService.getBikes(id);
        return ResponseEntity.ok(bikes);
    }
}
