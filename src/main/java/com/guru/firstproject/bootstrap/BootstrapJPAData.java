package com.guru.firstproject.bootstrap;

import com.guru.firstproject.entities.BuyerJPA;
import com.guru.firstproject.entities.CarJPA;
import com.guru.firstproject.model.BuyerDTO;
import com.guru.firstproject.model.CarBrand;
import com.guru.firstproject.repositories.BuyerRepository;
import com.guru.firstproject.repositories.CarRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class BootstrapJPAData implements CommandLineRunner {

    private final CarRepository carRepository;

    private final BuyerRepository buyerRepository;

    @Override
    public void run(String... args) throws Exception {
        loadCarData();
        loadBuyerData();

    }

    private void loadCarData() {
        CarJPA carJPA1 = CarJPA.builder()

                .brand(CarBrand.FORD)
                .type("Sports")
                .manufactureDate(LocalDate.now())
                .price(new BigDecimal("7500.00"))
                .model("Corvid")
                .build();
        CarJPA carJPA2 = CarJPA.builder()

                .brand(CarBrand.BMW)
                .type("Rally")
                .manufactureDate(LocalDate.of(2003,5,13))
                .price(new BigDecimal("5600.00"))
                .model("M3 GTR")
                .build();
        CarJPA carJPA3 = CarJPA.builder()

                .brand(CarBrand.VW)
                .type("Sedan")
                .manufactureDate(LocalDate.of(2015,8,16))
                .price(new BigDecimal("2300.00"))
                .model("R4")
                .build();
        CarJPA carJPA4 = CarJPA.builder()

                .brand(CarBrand.TOYOTA)
                .type("Drifter")
                .manufactureDate(LocalDate.of(2007,3,17))
                .price(new BigDecimal("4400.00"))
                .model("Supra")
                .build();
        List<CarJPA> carJPAList = List.of(carJPA1,carJPA2, carJPA3, carJPA4);
        carRepository.saveAll(carJPAList);

    }

    private void loadBuyerData() {
        BuyerJPA buyerJPA1 = BuyerJPA.builder()
                .firstName("Ralf")
                .lastName("Schuhmacher")
                .age(47)
                .budget(7500)
                .build();
        BuyerJPA buyerJPA2 = BuyerJPA.builder()
                .firstName("Arnold")
                .lastName("Schwarz")
                .age(58)
                .budget(15000)
                .build();
        BuyerJPA buyerJPA3 = BuyerJPA.builder()
                .firstName("Osama")
                .lastName("Alqasem")
                .age(35)
                .budget(250000)
                .build();

        List<BuyerJPA> buyerJPAList = List.of(buyerJPA1, buyerJPA2, buyerJPA3);
        buyerRepository.saveAll(buyerJPAList);
    }
}
