package com.guru.firstproject.services;

import com.guru.firstproject.entities.Product;

public interface ProductService {
    Iterable<Product> findAll();
}
