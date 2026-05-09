package com.guru.firstproject.controllers;

import com.guru.firstproject.model.CarDTO;
import com.guru.firstproject.model.CarBrand;
import com.guru.firstproject.services.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/cars")
public class CarController {
    private final CarService carService;
    
    @DeleteMapping("{carId}")
    public ResponseEntity handleDelete(@PathVariable("carId") UUID carId){
        carService.deleteCarById(carId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{carId}")
    public ResponseEntity handleUpdaate(@PathVariable("carId") UUID carId, @RequestBody CarDTO carDTO){

        carService.updateCarById(carId, carDTO);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody CarDTO carDTO){
        CarDTO newCarDTO = carService.addCar(carDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/cars/"+ newCarDTO.getId().toString());
        return new ResponseEntity( headers ,HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, name = "Qwer")
    public List<CarDTO> carsList(){
        return carService.listTheCars();
    }

    @RequestMapping(value = "{carId}",method = RequestMethod.GET)
    public CarDTO getCarById(@PathVariable("carId") UUID carId){
        log.debug("Inside getCarById -- in Controller");

        return carService.getCarById(carId).orElseThrow(NoClassDefFoundError::new);
    }

    @RequestMapping(value = "/byBrand/{carBrand}",method = RequestMethod.GET)
    public CarDTO getCarByBrand(@PathVariable("carBrand") CarBrand carBrand){
        return carService.getCarByBrand(carBrand);
    }


}
