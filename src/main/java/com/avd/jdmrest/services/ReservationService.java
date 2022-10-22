package com.avd.jdmrest.services;

import com.avd.jdmrest.domain.Reservation;

import java.util.Optional;

public interface ReservationService {

    /**
     * Get all reservations
     * @return Iterable<Reservation>
     */
    Iterable<Reservation> getAll();

    /**
     * Create a new reservation
     * @param reservation
     * @return Reservation
     */

    Reservation createReservation(Reservation reservation);

    /**
     * Get reservation by id
     * @param id
     * @return Optional<Reservation>
     */

    Optional<Reservation> getById(Long id);

    /**
     * Delete reservation by id
     * @param id
     * @return void
     */

    void deleteReservationById(Long id);
}
