package com.avd.jdmrest.controller;

import com.avd.jdmrest.domain.Reservation;
import com.avd.jdmrest.services.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    /**
     * retrieve all reservations
     * @return
     */

    @GetMapping
    public Iterable<Reservation> getAllReservations() {
        return reservationService.getAll();
    }

    /**
     * create a new reservation
     * @param reservation
     * @return
     */
    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationService.createReservation(reservation);
    }

    /**
     * retrieves a reservation by id
     * @param id
     * @return
     */

    @GetMapping("/{id}")
    public Optional<Reservation> getReservationById(@PathVariable Long id) {
        return reservationService.getById(id);
    }


    /**
     * delete reservation by id
     * @param id
     * @return ResponseEntity
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReservationById(@PathVariable Long id) {
        if(reservationService.getById(id).isPresent()) {
            reservationService.deleteReservationById(id);
            return ResponseEntity.ok("Reservation deleted");
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * update a reservation based of the id
     * @param id
     * @param reservation
     * @return
     */

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable Long id, @RequestBody Reservation reservation) {
        if(reservationService.getById(id).isPresent()) {
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
            return ResponseEntity.notFound().build();
        }
    }


    /**
     * finalizes a reservation by setting the reservationFinal field to true
     * @param id
     * @return
     */
    @PutMapping("/final/{id}")
    public ResponseEntity<Reservation> finalReservation(@PathVariable Long id) {
        if(reservationService.getById(id).isPresent()) {
            Reservation reservationToUpdate = reservationService.getById(id).get();
            reservationToUpdate.setReservationFinal(true);
            reservationService.createReservation(reservationToUpdate);
            return ResponseEntity.ok(reservationToUpdate);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
