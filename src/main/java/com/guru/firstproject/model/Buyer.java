package com.guru.firstproject.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;
@Builder
@Data
public class Buyer {
    private UUID id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Integer budget;
}
