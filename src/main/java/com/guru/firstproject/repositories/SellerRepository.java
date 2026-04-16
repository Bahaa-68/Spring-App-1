package com.guru.firstproject.repositories;

import com.guru.firstproject.entities.Seller;
import org.springframework.data.repository.CrudRepository;

public interface SellerRepository extends CrudRepository<Seller, Long> {
}
