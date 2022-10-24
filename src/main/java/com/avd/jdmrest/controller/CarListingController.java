package com.avd.jdmrest.controller;

import com.avd.jdmrest.domain.CarListing;
import com.avd.jdmrest.services.CarListingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/car")
public class CarListingController extends AbstractController{

    private final CarListingService carListingService;

    public CarListingController(CarListingService carListingService) {
        this.carListingService = carListingService;
    }

    /**
     * retrieve all cars
     * @return Iterable<CarListing>
     */
    @GetMapping
    public Iterable<CarListing> getAllCars() {
        log("getAllCars");
        return carListingService.getAll();
    }

    /**
     * create a new car
     * @param id car id
     * @return ResponseEntity<CarListing>
     */
    @GetMapping("/{id}")
    public ResponseEntity<CarListing> getCarById(@PathVariable Long id) {
        if (carListingService.getById(id).isPresent()) {
            log("getCarById found", id);
            return ResponseEntity.ok(carListingService.getById(id).get());
        } else {
            log("getCarById not found", id);
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * create a new car
     * @param carListing car
     * @return ResponseEntity<CarListing>
     */
    @PostMapping
    public CarListing createCar(@Valid @RequestBody CarListing carListing) {
        log("createCar");
        return carListingService.createCar(carListing);
    }

    /**
     * delete car by id
     * @param id car id
     * @return ResponseEntity<String>
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCarById(@PathVariable Long id) {
        if(carListingService.getById(id).isPresent()) {
            log("deleteCarById found", id);
            carListingService.deleteById(id);
            return ResponseEntity.ok("Car deleted");
        }
        else {
            log("deleteCarById not found", id);
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * update car by id
     * @param id car id
     * @param carListing car
     * @return ResponseEntity<CarListing>
     */
    @PutMapping("/{id}")
    public ResponseEntity<CarListing> updateCar(@PathVariable Long id,@Valid @RequestBody CarListing carListing) {
        if (carListingService.getById(id).isPresent()) {
            log("updateCar found", id);
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
            log("updateCar not found", id);
            return ResponseEntity.notFound().build();

        }
    }

    @GetMapping("/tco/{id}")
    public ResponseEntity<Double> getTCO(@PathVariable Long id) {
        if (carListingService.getById(id).isPresent()) {
            log("getTCO found", id);
            return ResponseEntity.ok(carListingService.getTCO(carListingService.getById(id).get()));
        } else {
            log("getTCO not found", id);
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/cpk/{id}")
    public ResponseEntity<Double> getCPKM(@PathVariable Long id) {
        if (carListingService.getById(id).isPresent()) {
            log("getCPKM found", id);
            return ResponseEntity.ok(carListingService.getById(id).get().costPerKilometer);
        } else {
            log("getCPKM not found", id);
            return ResponseEntity.notFound().build();
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions( MethodArgumentNotValidException ex) {
        return handleErrors(ex);
    }
}
