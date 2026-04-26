package com.guru.firstproject.controllers;

import com.guru.firstproject.model.Car;
import com.guru.firstproject.services.CarService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import java.util.UUID;
@Slf4j
@AllArgsConstructor
@Controller
public class CarController {
    private final CarService carService;

    public Car getCarById(UUID id){
        log.debug("Inside getCarById -- in Controller");

        return carService.getCarById(id);
    }
}
