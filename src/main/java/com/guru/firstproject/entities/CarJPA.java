package com.guru.firstproject.entities;

import com.guru.firstproject.model.CarBrand;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarJPA {
    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator
    @Column(length = 8, columnDefinition = "varchar", nullable = false, updatable = false, unique = true)
    private UUID id;
    private CarBrand brand;
    private String type;
    private String model;
    private BigDecimal price;
    private LocalDate manufactureDate;
}
