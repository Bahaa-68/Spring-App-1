package com.guru.firstproject.repositories;

import com.guru.firstproject.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
