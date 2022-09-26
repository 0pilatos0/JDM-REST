package com.pilatos.jdmrest.controller;

import com.pilatos.jdmrest.model.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") String id) {
        //TODO actualy send customer
        return ResponseEntity.ok(new Customer());
    }
}
