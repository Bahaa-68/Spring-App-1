package com.guru.firstproject.controllers;

import com.guru.firstproject.model.Car;
import com.guru.firstproject.services.CarService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("api/v1/cars")
public class CarController {
    private final CarService carService;

    @RequestMapping(method = RequestMethod.GET, name = "Qwer")
    public List<Car> carsList(){
        return carService.listTheCars();
    }

    @RequestMapping(value = "{carId}",method = RequestMethod.GET)
    public Car getCarById(@PathVariable("carId") UUID carId){
        log.debug("Inside getCarById -- in Controller");

        return carService.getCarById(carId);
    }


}
