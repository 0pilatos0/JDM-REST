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

    @GetMapping
    public Iterable<Reservation> getAllReservations() {
        return reservationService.getAll();
    }

    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationService.createReservation(reservation);
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservationById(@PathVariable Long id) {
        return reservationService.getById(id);
    }

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
}
