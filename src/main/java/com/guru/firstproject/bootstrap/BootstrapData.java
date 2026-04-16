package com.guru.firstproject.bootstrap;

import com.guru.firstproject.entities.Product;
import com.guru.firstproject.entities.Seller;
import com.guru.firstproject.repositories.ProductRepository;
import com.guru.firstproject.repositories.SellerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final SellerRepository sellerRepository;
    private final ProductRepository productRepository;

    public BootstrapData(SellerRepository sellerRepository, ProductRepository productRepository) {
        this.sellerRepository = sellerRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Seller erich = new Seller();
        erich.setFirstname("Erich");
        erich.setLastname("Remark");

        Product book = new Product();
        book.setName("Im Westen Nichts Neues");
        book.setPrice(35);

        Seller saveErich = sellerRepository.save(erich);
        Product saveBook = productRepository.save(book);



        Seller siegward = new Seller();
        siegward.setFirstname("Siegward");
        siegward.setLastname("Of Katarina");

        Product sword = new Product();
        sword.setName("Giant Slayer");
        sword.setPrice(117);

        Seller saveSiegward = sellerRepository.save(siegward);
        Product saveSword = productRepository.save(sword);


        saveErich.getProductSet().add(saveBook);
        saveSiegward.getProductSet().add(saveSword);

        sellerRepository.save(saveErich);
        sellerRepository.save(saveSiegward);

        IO.println("In Bootstrap \n User Count : "+ sellerRepository.count()+"\nProduct Count : "+productRepository.count()+"  "+sellerRepository);

    }
}
