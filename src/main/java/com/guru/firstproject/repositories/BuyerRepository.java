package com.guru.firstproject.repositories;

import com.guru.firstproject.entities.BuyerJPA;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BuyerRepository extends JpaRepository<BuyerJPA, UUID> {
}
