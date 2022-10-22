package com.avd.jdmrest.controller;

import com.avd.jdmrest.domain.CarListing;
import com.avd.jdmrest.services.CarListingService;
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
    public Optional<CarListing> getCarById(@PathVariable Long id) {
        return carListingService.getById(id);
    }

    @PostMapping
    public CarListing createCar(@RequestBody CarListing carListing) {
        return carListingService.createCar(carListing);
    }
}
