package com.avd.jdmrest.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class RentCondition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Getter
    @Setter
    public LocalDate rentDate;
    @Getter
    @Setter
    public String postalCode;
    @Getter
    @Setter
    public String houseNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RentCondition() {

    }

    public RentCondition(LocalDate rentDate, String postalCode, String houseNumber) {
        this.rentDate = rentDate;
        this.postalCode = postalCode;
        this.houseNumber = houseNumber;
    }
}
