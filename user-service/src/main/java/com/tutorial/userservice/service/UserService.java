package com.tutorial.userservice.service;

import com.tutorial.userservice.entity.User;
import com.tutorial.userservice.modelos.Bike;
import com.tutorial.userservice.modelos.Car;
import com.tutorial.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RestTemplate restTemplate;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User save(User user) {

        return userRepository.save(user);
    }

    public List<Car> getCars(Long id) {
        return restTemplate.getForObject("http://localhost:8002/car/user/" + id, List.class);

    }

    public List<Bike> getBikes(Long id) {
        return restTemplate.getForObject("http://localhost:8003/bike/user/" + id, List.class);

    }
}
