package com.guru.firstproject.services;

import com.guru.firstproject.model.Car;
import org.springframework.stereotype.Service;

import java.util.UUID;

public interface CarService {
    Car getCarById(UUID id);
}
