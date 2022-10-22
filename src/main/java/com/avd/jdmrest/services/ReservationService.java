package com.avd.jdmrest.services;

import com.avd.jdmrest.domain.Reservation;

import java.util.Optional;

public interface ReservationService {
    Iterable<Reservation> getAll();

    Reservation createReservation(Reservation reservation);

    Optional<Reservation> getById(Long id);

    void deleteReservationById(Long id);
}
