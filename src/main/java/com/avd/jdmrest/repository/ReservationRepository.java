package com.avd.jdmrest.repository;

import com.avd.jdmrest.domain.Customer;
import com.avd.jdmrest.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long>
{
    Iterable<Reservation> getReservationByRenter(Customer customer );
}
