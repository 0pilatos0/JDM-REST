package com.avd.jdmrest.services;

import com.avd.jdmrest.domain.Reservation;
import com.avd.jdmrest.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService{

    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }


    /**
     * @InheritDoc
     * @return Iterable<Reservation>
     */
    @Override
    public Iterable<Reservation> getAll() {
       return reservationRepository.findAll();
    }

    /**
     * @InheritDoc
     * @param reservation
     * @return Reservation
     */
    @Override
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    /**
     * @InheritDoc
     * @param id
     * @return Optional<Reservation>
     */

    @Override
    public Optional<Reservation> getById(Long id) {
        return reservationRepository.findById(id);
    }

    /**
     * @InheritDoc
     * @param id
     * @return void
     */
    @Override
    public void deleteReservationById(Long id) {
        reservationRepository.deleteById(id);
    }
}
