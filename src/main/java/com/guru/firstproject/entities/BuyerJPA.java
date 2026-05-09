package com.guru.firstproject.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BuyerJPA {
    @Id
    @GeneratedValue(generator = "UUID" )
    //@Column(length = 16, nullable = false)
    @UuidGenerator
    private UUID id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Integer budget;
}
