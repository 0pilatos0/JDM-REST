package com.avd.jdmrest.domain;

import lombok.Getter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Reservation {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public LocalDate reservationDate;
    public LocalDate returnDate;
    public boolean reservationFinal;
    public String termsAndConditions;

    @ManyToOne()
    @JoinColumn(name = "customer_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    public Customer renter;

    @OneToOne()
    @JoinColumn(name = "car_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    public CarListing carListing;

    public Reservation() {
    }

    public Reservation(LocalDate reservationDate, LocalDate returnDate, boolean reservationFinal, String termsAndConditions, Customer renter, CarListing carListing) {
        this.reservationDate = reservationDate;
        this.returnDate = returnDate;
        this.reservationFinal = reservationFinal;
        this.termsAndConditions = termsAndConditions;
        this.renter = renter;
        this.carListing = carListing;
    }

}
