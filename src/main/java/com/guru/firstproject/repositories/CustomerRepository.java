package com.guru.firstproject.repositories;

import com.guru.firstproject.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
}
