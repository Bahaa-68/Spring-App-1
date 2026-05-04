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
    private Map<CarBrand, Car> carMapByBrand;
    private Map<UUID,Car> carMap;
    public CarServiceImp(){
        this.carMap = new HashMap<>();
        this.carMapByBrand = new HashMap<>();
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

        carMapByBrand.put(car1.getBrand(),car1);
        carMapByBrand.put(car2.getBrand(),car2);
        carMapByBrand.put(car3.getBrand(),car3);
    }

    @Override
    public List<Car> listTheCars() {
        return new ArrayList<>(carMap.values());
    }

    @Override
    public Car getCarById(UUID id){
        log.debug("Inside getCarById in Services");
        return  carMap.get(id);
    }
    @Override
    public Car addCar(Car car) {
        Car newCar = Car.builder()
                .id(UUID.randomUUID())
                .brand(car.getBrand())
                .type(car.getType())
                .model(car.getModel())
                .price(car.getPrice())
                .manufactureDate(LocalDate.now())
                .build();
        carMap.put(newCar.getId(), newCar);
        return newCar;
    }
    public void updateCarById(UUID id, Car car){
        Car current = carMap.get(id);
        current.setType(car.getType());
        current.setModel(car.getModel());
        current.setPrice(car.getPrice());
        current.setManufactureDate(car.getManufactureDate());
        current.setBrand(car.getBrand());

        carMap.put(current.getId(),current);
    }
    @Override
    public Car getCarByBrand(CarBrand carBrand){
        return carMapByBrand.get(carBrand);
    }
    @Override
    public void deleteCarById(UUID carId){
        carMap.remove(carId);
    }
}
