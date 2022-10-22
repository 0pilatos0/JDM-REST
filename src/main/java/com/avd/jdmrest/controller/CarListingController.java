package com.avd.jdmrest.controller;

import com.avd.jdmrest.domain.CarListing;
import com.avd.jdmrest.services.CarListingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/car")
public class CarListingController {

    private final CarListingService carListingService;

    public CarListingController(CarListingService carListingService) {
        this.carListingService = carListingService;
    }

    @GetMapping
    public Iterable<CarListing> getAllCars() {
        return carListingService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarListing> getCarById(@PathVariable Long id) {
        if (carListingService.getById(id).isPresent()) {
            return ResponseEntity.ok(carListingService.getById(id).get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public CarListing createCar(@RequestBody CarListing carListing) {
        return carListingService.createCar(carListing);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarListing> updateCar(@PathVariable Long id, @RequestBody CarListing carListing) {
        if (carListingService.getById(id).isPresent()) {
            CarListing carToUpdate = carListingService.getById(id).get();

            carToUpdate.setBrand(carListing.getBrand());
            carToUpdate.setCarType(carListing.getCarType());
            carToUpdate.setColor(carListing.getColor());
            carToUpdate.setSeats(carListing.getSeats());
            carToUpdate.setPrice(carListing.getPrice());
            carToUpdate.setOwner(carListing.getOwner());
            carToUpdate.setDescription(carListing.getDescription());
            carToUpdate.setCostPerKilometer(carListing.getCostPerKilometer());
            carToUpdate.setLicensePlate(carListing.getLicensePlate());

            carListingService.createCar(carToUpdate);
            return ResponseEntity.ok(carToUpdate);
        } else {
            return ResponseEntity.notFound().build();

        }
    }
}
