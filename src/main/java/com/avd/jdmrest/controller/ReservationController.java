package com.avd.jdmrest.controller;

import com.avd.jdmrest.domain.Reservation;
import com.avd.jdmrest.services.RentConditionService;
import com.avd.jdmrest.services.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/reservation")
public class ReservationController extends AbstractController {
    private final ReservationService reservationService;
    private final RentConditionService rentConditionService;

    public ReservationController(ReservationService reservationService, RentConditionService rentConditionService) {
        this.reservationService = reservationService;
        this.rentConditionService = rentConditionService;
    }

    /**
     * retrieve all reservations
     * @return Iterable<Reservation>
     */
    @GetMapping
    public Iterable<Reservation> getAllReservations() {
        log("getAllReservations");
        return reservationService.getAll();
    }

    @GetMapping("/user/{id}")
    public Iterable<Reservation> getReservationsByUserId(@PathVariable Long id) {
        log("getReservationsByUserId");
        return reservationService.getReservationsByUserId(id);
    }

    /**
     * create a new reservation
     * @param reservation reservation
     * @return Reservation
     */
    @PostMapping
    public Reservation createReservation(@Valid @RequestBody Reservation reservation) {
        log("createReservation");
        rentConditionService.createRentCondition(reservation.getRentConditions());
        return reservationService.createReservation(reservation);
    }

    /**
     * retrieves a reservation by id
     * @param id reservation id
     * @return ResponseEntity<Reservation>
     */
    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id) {
        if(reservationService.getById(id).isPresent()) {
            log("getReservationById found", id);
            return ResponseEntity.ok(reservationService.getById(id).get());
        } else {
            log("getReservationById not found", id);
            return ResponseEntity.notFound().build();
        }
    }


    /**
     * delete reservation by id
     * @param id reservation id
     * @return ResponseEntity<String>
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReservationById(@PathVariable Long id) {
        if(reservationService.getById(id).isPresent()) {
            log("deleteReservationById found", id);
            reservationService.deleteReservationById(id);
            return ResponseEntity.ok("Reservation deleted");
        }
        else {
            log("deleteReservationById not found", id);
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * update a reservation based of the id
     * @param id reservation id
     * @param reservation reservation
     * @return ResponseEntity<Reservation>
     */
    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable Long id, @Valid @RequestBody Reservation reservation) {
        if(reservationService.getById(id).isPresent()) {
            log("updateReservation found", id);
            Reservation reservationToUpdate = reservationService.getById(id).get();

            reservationToUpdate.setReservationDate(reservation.getReservationDate());
            reservationToUpdate.setReservationFinal(reservation.isReservationFinal());
            reservationToUpdate.setTermsAndConditions(reservation.getTermsAndConditions());
            reservationToUpdate.setReturnDate(reservation.getReturnDate());

            reservationToUpdate.setRenter(reservation.getRenter());
            reservationToUpdate.setCarListing(reservation.getCarListing());


            reservationService.createReservation(reservationToUpdate);
            return ResponseEntity.ok(reservationToUpdate);
        }
        else {
            log("updateReservation not found", id);
            return ResponseEntity.notFound().build();
        }
    }


    /**
     * finalizes a reservation by setting the reservationFinal field to true
     * @param id reservation id
     * @return ResponseEntity<Reservation>
     */
    @PutMapping("/final/{id}")
    public ResponseEntity<Reservation> finalReservation(@PathVariable Long id) {
        if(reservationService.getById(id).isPresent()) {
            log("finalReservation found", id);
            Reservation reservationToUpdate = reservationService.getById(id).get();
            reservationToUpdate.setReservationFinal(true);
            reservationService.createReservation(reservationToUpdate);
            return ResponseEntity.ok(reservationToUpdate);
        }
        else {
            log("finalReservation not found", id);
            return ResponseEntity.notFound().build();
        }
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions( MethodArgumentNotValidException ex) {
        return handleErrors(ex);
    }
}
