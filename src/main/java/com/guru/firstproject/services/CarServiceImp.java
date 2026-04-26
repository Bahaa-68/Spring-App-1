package com.guru.firstproject.services;

import com.guru.firstproject.model.Car;
import com.guru.firstproject.model.CarBrand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
@Slf4j
@Service
public class CarServiceImp implements CarService{

    @Override
    public Car getCarById(UUID id){
        log.debug("Inside getCarById in Services");
        return Car.builder()
                .id(id)
                .brand(CarBrand.FORD)
                .type("Sports")
                .manufactureDate(LocalDate.now())
                .price(new BigDecimal("7500.00"))
                .model("Corvid")
                .build();
    }
}
