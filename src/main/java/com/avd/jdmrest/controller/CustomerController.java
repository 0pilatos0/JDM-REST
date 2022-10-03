package com.avd.jdmrest.controller;

import com.avd.jdmrest.entities.Customer;
import com.avd.jdmrest.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	private final CustomerService customerService;

	public CustomerController( CustomerService customerService ) {
		this.customerService = customerService;
	}

	@GetMapping
	public Iterable<Customer> getAllCustomers() {
		return customerService.getAll();
	}

	@GetMapping("/{id}")
	public Optional<Customer> getCustomerById(@PathVariable Long id) {
		return customerService.getById(id);
	}

	@PostMapping
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerService.createCustomer(customer);
	}
}
