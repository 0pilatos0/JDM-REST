package com.avd.jdmrest.models;

import com.avd.jdmrest.enums.Brand;
import com.avd.jdmrest.enums.CarType;


public class Car {
    private String licensePlate;
    private Brand brand;
    private CarType carType;
    private int price;
    private int costPerKilometer;
    private String color;
}
