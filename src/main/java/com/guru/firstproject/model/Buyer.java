package com.guru.firstproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Buyer {
    private UUID id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Integer budget;

}
