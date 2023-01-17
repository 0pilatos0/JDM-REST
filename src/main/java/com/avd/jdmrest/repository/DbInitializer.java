package com.avd.jdmrest.repository;

import com.avd.jdmrest.domain.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DbInitializer {
    public DbInitializer(CustomerRepository customerRepository, CarListingRepository carListingRepository, ReservationRepository reservationRepository, RentConditionRepository rentConditionRepository, CarConditionRepository carConditionRepository) {

        /*Database initialization to help testing the application without having to manually add data to the database.*/

        Customer customer1 = new Customer("John",  LocalDate.of(1990, 1, 1), "1234", "1234");
        Customer customer2 = new Customer("Jane",  LocalDate.of(1990, 1, 1), "1234", "1234");
        Customer customer3 = new Customer("Jack",  LocalDate.of(1990, 1, 1), "1234", "1234");

        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);

        CarCondition carCondition1 = new CarCondition(VisibleDamageType.Scratches, false, "No");
        CarCondition carCondition2 = new CarCondition(VisibleDamageType.Dents, false, "The air conditioner is broken.");
        CarCondition carCondition3 = new CarCondition(VisibleDamageType.WindshieldCrack, true, "The passenger seat window does not roll down.");

        carConditionRepository.save(carCondition1);
        carConditionRepository.save(carCondition2);
        carConditionRepository.save(carCondition3);

        List<String> images = List.of();

        CarListing carListing1 = new CarListing("AA-BB-99", Brand.Audi, CarType.ICE, "Black", 25000, 0.05, customer1, 5, "This is a very nice car!", images, carCondition1);
        CarListing carListing2 = new CarListing("CC-DD-11", Brand.Chevrolet, CarType.FCEV, "Red", 35000, 0.06, customer2, 5, "What a classic!", images, carCondition2);
        CarListing carListing3 = new CarListing("EE-FF-55", Brand.Fiat, CarType.BEV, "Yellow", 17500, 0.09, customer3, 4, "A little old but does the job!", images, carCondition3);

        carListingRepository.save(carListing1);
        carListingRepository.save(carListing2);
        carListingRepository.save(carListing3);

        RentCondition rentCondition1 = new RentCondition(LocalDate.of(2020, 1, 1), "4254EE", "47");

        rentConditionRepository.save(rentCondition1);

        Reservation reservation1 = new Reservation(LocalDate.of(2020, 1, 1), LocalDate.of(2020, 1, 8), true, "I agree to the terms and conditions", customer1, carListing1, rentCondition1);

        reservationRepository.save(reservation1);
    }
}
