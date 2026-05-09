package com.guru.firstproject.Mappers;

import com.guru.firstproject.entities.CarJPA;
import com.guru.firstproject.model.CarDTO;
import org.mapstruct.Mapper;

@Mapper
public interface BuyerMapper {
    CarDTO carJpaToCarDto(CarJPA carJPA);
    CarJPA carDtoToCarJpa(CarDTO carDTO);
}
