package com.avd.jdmrest.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Reservation {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter
    @Setter
    @NotNull
    public LocalDate reservationDate;
    @Getter
    @Setter
    @NotNull
    public LocalDate returnDate;

    @Getter
    @Setter
    @NotNull
    public boolean reservationFinal;
    @Getter
    @Setter
    @NotNull
    public String termsAndConditions;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "rent_conditions_ID")
    @NotNull
    public RentCondition rentConditions;

    @Getter
    @Setter
    @ManyToOne()
    @JoinColumn(name = "customer_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    public Customer renter;

    @Getter
    @Setter
    @OneToOne()
    @JoinColumn(name = "car_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    public CarListing carListing;

    public Reservation() {
    }

    public Reservation(LocalDate reservationDate, LocalDate returnDate, boolean reservationFinal, String termsAndConditions, Customer renter, CarListing carListing, RentCondition rentConditions) {
        this.reservationDate = reservationDate;
        this.returnDate = returnDate;
        this.reservationFinal = reservationFinal;
        this.termsAndConditions = termsAndConditions;
        this.renter = renter;
        this.carListing = carListing;
        this.rentConditions = rentConditions;

    }
}
