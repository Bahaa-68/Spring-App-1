package com.guru.firstproject.services;

import com.guru.firstproject.model.CarDTO;
import com.guru.firstproject.model.CarBrand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

@Slf4j
@Service
public class CarServiceImp implements CarService{
    private Map<CarBrand, CarDTO> carMapByBrand;
    private Map<UUID, CarDTO> carMap;
    public CarServiceImp(){
        this.carMap = new HashMap<>();
        this.carMapByBrand = new HashMap<>();
       CarDTO carDTO1 = CarDTO.builder()
                .id(UUID.randomUUID())
                .brand(CarBrand.FORD)
                .type("Sports")
                .manufactureDate(LocalDate.now())
                .price(new BigDecimal("7500.00"))
                .model("Corvid")
                .build();
        CarDTO carDTO2 = CarDTO.builder()
                .id(UUID.randomUUID())
                .brand(CarBrand.BMW)
                .type("Rally")
                .manufactureDate(LocalDate.of(2003,5,13))
                .price(new BigDecimal("5600.00"))
                .model("M3 GTR")
                .build();
        CarDTO carDTO3 = CarDTO.builder()
                .id(UUID.randomUUID())
                .brand(CarBrand.VW)
                .type("Sedan")
                .manufactureDate(LocalDate.of(2015,8,16))
                .price(new BigDecimal("2300.00"))
                .model("R4")
                .build();
        CarDTO carDTO4 = CarDTO.builder()
                .id(UUID.randomUUID())
                .brand(CarBrand.TOYOTA)
                .type("Drifter")
                .manufactureDate(LocalDate.of(2007,3,17))
                .price(new BigDecimal("4400.00"))
                .model("Supra")
                .build();

        carMap.put(carDTO1.getId(), carDTO1);
        carMap.put(carDTO2.getId(), carDTO2);
        carMap.put(carDTO3.getId(), carDTO3);
        carMap.put(carDTO4.getId(), carDTO4);

        carMapByBrand.put(carDTO1.getBrand(), carDTO1);
        carMapByBrand.put(carDTO2.getBrand(), carDTO2);
        carMapByBrand.put(carDTO3.getBrand(), carDTO3);
    }

    @Override
    public List<CarDTO> listTheCars() {
        return new ArrayList<>(carMap.values());
    }

    @Override
    public Optional<CarDTO> getCarById(UUID id){
        log.debug("Inside getCarById in Services");
        return  Optional.of(carMap.get(id));
    }
    @Override
    public CarDTO addCar(CarDTO carDTO) {
        CarDTO newCarDTO = CarDTO.builder()
                .id(UUID.randomUUID())
                .brand(carDTO.getBrand())
                .type(carDTO.getType())
                .model(carDTO.getModel())
                .price(carDTO.getPrice())
                .manufactureDate(LocalDate.now())
                .build();
        carMap.put(newCarDTO.getId(), newCarDTO);
        return newCarDTO;
    }
    public Optional<CarDTO> updateCarById(UUID id, CarDTO carDTO){
        CarDTO current = carMap.get(id);
        current.setType(carDTO.getType());
        current.setModel(carDTO.getModel());
        current.setPrice(carDTO.getPrice());
        current.setManufactureDate(carDTO.getManufactureDate());
        current.setBrand(carDTO.getBrand());

        carMap.put(current.getId(),current);
        return Optional.of(current);
    }
    @Override
    public CarDTO getCarByBrand(CarBrand carBrand){
        return carMapByBrand.get(carBrand);
    }
    @Override
    public Boolean deleteCarById(UUID carId){
        carMap.remove(carId); return true;
    }
}
