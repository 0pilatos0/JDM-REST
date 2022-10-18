package com.avd.jdmrest.repository;

import com.avd.jdmrest.domain.Brand;
import com.avd.jdmrest.domain.CarListing;
import com.avd.jdmrest.domain.CarType;
import com.avd.jdmrest.domain.Customer;
import org.springframework.stereotype.Component;

@Component
public class DbInitializer {
    public DbInitializer(CustomerRepository customerRepository, CarListingRepository carListingRepository) {
        //super coole initializer ding die er voor zorgt dat er iets van testdata is
        Customer customer1 = new Customer("John");
        Customer customer2 = new Customer("Jane");
        Customer customer3 = new Customer("Jack");

        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);

        CarListing carListing1 = new CarListing("AA-BB-99", Brand.Audi, CarType.ICE, "Black", 25000, 0.05, customer1, 5, "This is a very nice car!");
        CarListing carListing2 = new CarListing("CC-DD-11", Brand.Chevrolet, CarType.FCEV, "Red", 35000, 0.06, customer2, 5, "What a classic!");
        CarListing carListing3 = new CarListing("EE-FF-55", Brand.Fiat, CarType.BEV, "Yellow", 17500, 0.09, customer3, 4, "A little old but does the job!");

        carListingRepository.save(carListing1);
        carListingRepository.save(carListing2);
        carListingRepository.save(carListing3);
    }
}
