package com.guru.firstproject.services;

import com.guru.firstproject.model.Car;
import com.guru.firstproject.model.CarBrand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

@Slf4j
@Service
public class CarServiceImp implements CarService{

    private Map<UUID,Car> carMap;
    public CarServiceImp(){
        this.carMap = new HashMap<>();
       Car car1 = Car.builder()
                .id(UUID.randomUUID())
                .brand(CarBrand.FORD)
                .type("Sports")
                .manufactureDate(LocalDate.now())
                .price(new BigDecimal("7500.00"))
                .model("Corvid")
                .build();
        Car car2 = Car.builder()
                .id(UUID.randomUUID())
                .brand(CarBrand.BMW)
                .type("Rally")
                .manufactureDate(LocalDate.of(2003,5,13))
                .price(new BigDecimal("5600.00"))
                .model("M3 GTR")
                .build();
        Car car3 = Car.builder()
                .id(UUID.randomUUID())
                .brand(CarBrand.VW)
                .type("Sedan")
                .manufactureDate(LocalDate.of(2015,8,16))
                .price(new BigDecimal("2300.00"))
                .model("R4")
                .build();
        Car car4 = Car.builder()
                .id(UUID.randomUUID())
                .brand(CarBrand.TOYOTA)
                .type("Drifter")
                .manufactureDate(LocalDate.of(2007,3,17))
                .price(new BigDecimal("4400.00"))
                .model("Supra")
                .build();

        carMap.put(car1.getId(), car1);
        carMap.put(car2.getId(), car2);
        carMap.put(car3.getId(), car3);
        carMap.put(car4.getId(), car4);
    }

    @Override
    public List<Car> listTheCars() {
        return new ArrayList<>(carMap.values());

    }

    @Override
    public Car getCarById(UUID id){
        log.debug("Inside getCarById in Services");

        return  carMap.get(id);
//                Car.builder()
//                .id(id)
//                .brand(CarBrand.FORD)
//                .type("Sports")
//                .manufactureDate(LocalDate.now())
//                .price(new BigDecimal("7500.00"))
//                .model("Corvid")
//                .build();
    }
}
