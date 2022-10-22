package com.avd.jdmrest.controller;

import com.avd.jdmrest.domain.Customer;
import com.avd.jdmrest.services.CustomerService;
import org.springframework.http.ResponseEntity;
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

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
		if (customerService.getById(id).isPresent()) {
			customerService.deleteById(id);
			return ResponseEntity.ok("Customer deleted");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
