package com.guru.firstproject.bootstrap;

import com.guru.firstproject.entities.Customer;
import com.guru.firstproject.entities.Product;
import com.guru.firstproject.entities.Seller;
import com.guru.firstproject.repositories.CustomerRepository;
import com.guru.firstproject.repositories.ProductRepository;
import com.guru.firstproject.repositories.SellerRepository;
import com.guru.firstproject.services.ProductServiceImp;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class BootstrapData implements CommandLineRunner {

    private final SellerRepository sellerRepository;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;

    public BootstrapData(SellerRepository sellerRepository, ProductRepository productRepository, CustomerRepository customerRepository) {
        this.sellerRepository = sellerRepository;
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;

    }

    @Override
    public void run(String... args) throws Exception {
        Seller erich = new Seller();
        erich.setFirstname("Erich");
        erich.setLastname("Remark");

        Product book = new Product();
        book.setName("Im Westen Nichts Neues");
        book.setPrice(35);

//        Customer aaron = new Customer();
//        aaron.setUserName("Aaron_130");
//        aaron.setPayMethod("Cash");

        Seller saveErich = sellerRepository.save(erich);
        Product saveBook = productRepository.save(book);
       // Customer saveAaron = customerRepository.save(aaron);


        Seller siegward = new Seller();
        siegward.setFirstname("Siegward");
        siegward.setLastname("Of Katarina");

        Product sword = new Product();
        sword.setName("Giant Slayer");
        sword.setPrice(117);

        Customer adam = new Customer();
        adam.setUserName("adam002");
        adam.setPayMethod("PayPal");

        Seller saveSiegward = sellerRepository.save(siegward);
        Product saveSword = productRepository.save(sword);
        Customer saveAdam = customerRepository.save(adam);


        saveErich.getProductSet().add(saveBook);
        saveSiegward.getProductSet().add(saveSword);

        saveBook.getSellerSet().add(saveErich);
        saveSword.getSellerSet().add(saveSiegward);



        sellerRepository.save(saveErich);
        sellerRepository.save(saveSiegward);

        //customerRepository.save(saveAaron);
        //customerRepository.save(saveAdam);

        saveSword.setCustomer(saveAdam);
        saveBook.setCustomer(saveAdam);
        productRepository.save(saveSword);
        productRepository.save(saveBook);

        IO.println("In Bootstrap \n Sellers Count : "+ sellerRepository.count()+"\nProducts Count : "+productRepository.count()+" \nCustomer Count : "+ customerRepository.count());
        IO.println("Hash Code of Book is : "+Objects.hashCode(saveSiegward.getId()));
        

    }
}
