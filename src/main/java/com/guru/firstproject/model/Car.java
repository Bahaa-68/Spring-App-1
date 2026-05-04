package com.guru.firstproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    private UUID id;
    private CarBrand brand;
    private String type;
    private String model;
    private BigDecimal price;
    private LocalDate manufactureDate;
}
