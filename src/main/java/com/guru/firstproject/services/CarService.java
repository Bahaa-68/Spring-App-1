package com.guru.firstproject.services;

import com.guru.firstproject.model.Car;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public interface CarService {
    List<Car> listTheCars();

    Car getCarById(UUID id);
}
