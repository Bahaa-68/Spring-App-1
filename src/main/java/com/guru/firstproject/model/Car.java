package com.guru.firstproject.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
@Builder
@Data
public class Car {
    private UUID id;
    private CarBrand brand;
    private String type;
    private String model;
    private BigDecimal price;
    private LocalDate manufactureDate;
}
