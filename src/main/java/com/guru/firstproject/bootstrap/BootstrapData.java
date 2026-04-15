package com.guru.firstproject.bootstrap;

import com.guru.firstproject.entities.Product;
import com.guru.firstproject.entities.User;
import com.guru.firstproject.repositories.ProductRepository;
import com.guru.firstproject.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public BootstrapData(UserRepository userRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User erich = new User();
        erich.setFirstname("Erich");
        erich.setLastname("Remark");

        Product book = new Product();
        book.setName("Im Westen Nichts Neues");
        book.setPrice(35);

        User saveErich = userRepository.save(erich);
        Product saveBook = productRepository.save(book);



        User siegward = new User();
        siegward.setFirstname("Siegward");
        siegward.setLastname("Of Katarina");

        Product sword = new Product();
        sword.setName("Giant Slayer");
        sword.setPrice(117);

        User saveSiegward = userRepository.save(siegward);
        Product saveSword = productRepository.save(sword);



        saveErich.getProductSet().add(saveBook);
        saveSiegward.getProductSet().add(saveSword);
    }
}
