package com.avd.jdmrest.controllers;

import com.avd.jdmrest.models.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @GetMapping("/customer")
    public ResponseEntity<Customer> getCustomers(){
        //TODO add logic to get all customers
        return ResponseEntity.ok(new Customer());
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") String id) {
        //TODO add logic to get customer by id
        return ResponseEntity.ok(new Customer());
    }
}
