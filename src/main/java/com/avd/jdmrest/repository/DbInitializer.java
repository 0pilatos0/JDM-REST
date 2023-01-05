package com.avd.jdmrest.repository;

import com.avd.jdmrest.domain.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DbInitializer {
    public DbInitializer(CustomerRepository customerRepository, CarListingRepository carListingRepository, ReservationRepository reservationRepository, RentConditionRepository rentConditionRepository) {

        /*Database initialization to help testing the application without having to manually add data to the database.*/

        Customer customer1 = new Customer("John",  LocalDate.of(1990, 1, 1), "1234", "1234");
        Customer customer2 = new Customer("Jane",  LocalDate.of(1990, 1, 1), "1234", "1234");
        Customer customer3 = new Customer("Jack",  LocalDate.of(1990, 1, 1), "1234", "1234");

        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);

        List<String> images = List.of();

        CarListing carListing1 = new CarListing("AA-BB-99", Brand.Audi, CarType.ICE, "Black", 25000, 0.05, customer1, 5, "This is a very nice car!", images);
        CarListing carListing2 = new CarListing("CC-DD-11", Brand.Chevrolet, CarType.FCEV, "Red", 35000, 0.06, customer2, 5, "What a classic!", images);
        CarListing carListing3 = new CarListing("EE-FF-55", Brand.Fiat, CarType.BEV, "Yellow", 17500, 0.09, customer3, 4, "A little old but does the job!", images);

        carListingRepository.save(carListing1);
        carListingRepository.save(carListing2);
        carListingRepository.save(carListing3);

        RentCondition rentCondition1 = new RentCondition(LocalDate.of(2020, 1, 1), "4254EE", "47");
        RentCondition rentCondition2 = new RentCondition(LocalDate.of(2020, 1, 1), "4254EE", "47");
        RentCondition rentCondition3 = new RentCondition(LocalDate.of(2020, 1, 1), "4254EE", "47");

        rentConditionRepository.save(rentCondition1);
        rentConditionRepository.save(rentCondition2);
        rentConditionRepository.save(rentCondition3);

        Reservation reservation1 = new Reservation(LocalDate.of(2020, 1, 1), LocalDate.of(2020, 1, 8), true, "I agree to the terms and conditions", customer1, carListing1, rentCondition1);
        Reservation reservation2 = new Reservation(LocalDate.of(2020, 1, 1), LocalDate.of(2020, 1, 8), true, "I agree to the terms and conditions", customer2, carListing2, rentCondition2);
        Reservation reservation3 = new Reservation(LocalDate.of(2020, 1, 1), LocalDate.of(2020, 1, 8), true, "I agree to the terms and conditions", customer3, carListing3, rentCondition3);

        reservationRepository.save(reservation1);
        reservationRepository.save(reservation2);
        reservationRepository.save(reservation3);
    }
}
