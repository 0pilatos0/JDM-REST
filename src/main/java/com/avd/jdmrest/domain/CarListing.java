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
import java.util.List;

@Entity
public class CarListing {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter
    @Setter
    private String licensePlate;
    @Getter
    @Setter
    public Brand brand;
    @Getter
    @Setter
    public CarType carType;
    @Getter
    @Setter
    public String color;
    @Getter
    @Setter
    public int price;
    @Getter
    @Setter
    public double costPerKilometer;
    @Getter
    @Setter
    @ManyToOne()
    @JoinColumn(name = "owner_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Customer owner;
    @Getter
    @Setter
    public int seats;
    @Getter
    @Setter
    public String description;

    @ElementCollection
    public List<String> images;

    public CarListing() {

    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
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

