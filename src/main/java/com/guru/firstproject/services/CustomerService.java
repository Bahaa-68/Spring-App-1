package com.guru.firstproject.services;

import com.guru.firstproject.entities.Customer;

public interface CustomerService {
    Iterable<Customer> findAll();
}
