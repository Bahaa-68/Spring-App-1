package com.guru.firstproject.repositories;

import com.guru.firstproject.entities.CarJPA;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CarRepository extends JpaRepository<CarJPA, UUID> {
    
}
