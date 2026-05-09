package com.guru.firstproject.bootstrap;

import com.guru.firstproject.repositories.BuyerRepository;
import com.guru.firstproject.repositories.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BootstrapJPADataTest {
    @Autowired
    CarRepository carRepository;

    @Autowired
    BuyerRepository buyerRepository;

    BootstrapJPAData bootstrapJPAData;

    @BeforeEach
    void setUp(){

    }

    @Test
    void runTest() throws Exception {
        BootstrapJPAData bootstrapJPAData = new BootstrapJPAData(carRepository, buyerRepository);
        bootstrapJPAData.run(null);
        assertThat(buyerRepository.count()).isEqualTo(3);
    }
}