package com.avd.jdmrest.services;

import com.avd.jdmrest.domain.CarListing;
import com.avd.jdmrest.domain.Reservation;

import java.util.Optional;

public interface ReservationService {

    /**
     * Get all reservations
     * @return Iterable<Reservation>
     */
    Iterable<Reservation> getAll();

    Iterable<Reservation> getReservationsByUserId(Long id);

    /**
     * Create a new reservation
     * @param reservation reservation
     * @return Reservation
     */
    Reservation createReservation(Reservation reservation);

    /**
     * Get reservation by id
     * @param id reservation id
     * @return Optional<Reservation>
     */

    Optional<Reservation> getById(Long id);

    /**
     * Delete reservation by id
     * @param id reservation id
     * @return void
     */

    void deleteReservationById(Long id);

    Iterable<Reservation> getReservationsByCarId(Long id);
}
