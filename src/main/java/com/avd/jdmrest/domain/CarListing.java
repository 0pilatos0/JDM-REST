package com.avd.jdmrest.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class CarListing {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter
    @Setter
    @NotNull
    private String licensePlate;
    @Getter
    @Setter
    @NotNull
    public Brand brand;
    @Getter
    @Setter
    @NotNull
    public CarType carType;
    @Getter
    @Setter
    @NotNull
    public String color;
    @Getter
    @Setter
    @NotNull
    public int price;
    @Getter
    @Setter
    @NotNull
    public double costPerKilometer;
    @Getter
    @Setter
    @ManyToOne()
    @JoinColumn(name = "customer_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Customer owner;
    @Getter
    @Setter
    @NotNull
    public int seats;
    @Getter
    @Setter
    @NotNull
    public String description;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "carListing_id")
    @ElementCollection
    @Getter
    @Setter
    @NotNull
    @Column(length = 100000)
    public List<String> images;

    public CarListing() {

    }

    public CarListing(String licensePlate, Brand brand, CarType carType, String color, int price, double costPerKilometer, Customer owner, int seats, String description, List<String> images) {
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.carType = carType;
        this.color = color;
        this.price = price;
        this.costPerKilometer = costPerKilometer;
        this.owner = owner;
        this.seats = seats;
        this.description = description;
        this.images = images;

    }
}

