package com.avd.jdmrest.services;

import com.avd.jdmrest.domain.Customer;
import com.avd.jdmrest.domain.Reservation;
import com.avd.jdmrest.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService{

    private final ReservationRepository reservationRepository;
    private final CustomerService customerService;

    public ReservationServiceImpl(ReservationRepository reservationRepository, CustomerService customerService) {
        this.reservationRepository = reservationRepository;
        this.customerService = customerService;
    }


    /**
     * @InheritDoc
     * @return Iterable<Reservation>
     */
    @Override
    public Iterable<Reservation> getAll() {
       return reservationRepository.findAll();
    }

    @Override
    public Iterable<Reservation> getReservationsByUserId(Long id) {
        Customer customer = customerService.getById(id).get();
        return reservationRepository.getReservationByRenter(customer);
    }

    /**
     * @InheritDoc
     * @param reservation reservation
     * @return Reservation
     */
    @Override
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    /**
     * @InheritDoc
     * @param id reservation id
     * @return Optional<Reservation>
     */

    @Override
    public Optional<Reservation> getById(Long id) {
        return reservationRepository.findById(id);
    }

    /**
     * @InheritDoc
     * @param id reservation id
     * @return void
     */
    @Override
    public void deleteReservationById(Long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public Iterable<Reservation> getReservationsByCarId(Long id) {
        return reservationRepository.getReservationsByCarListingId(id);
    }
}
