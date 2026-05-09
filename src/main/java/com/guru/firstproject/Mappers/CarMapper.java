package com.guru.firstproject.Mappers;

import com.guru.firstproject.entities.CarJPA;
import com.guru.firstproject.model.CarDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CarMapper {
    CarDTO carToCarDto(CarJPA carJPA);
    CarJPA carDtoToCar(CarDTO carDTO);
}
