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

	@PutMapping("/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
		if (customerService.getById(id).isPresent()) {
			Customer customerToUpdate = customerService.getById(id).get();
			customerToUpdate.setUsername(customer.getUsername());
			customerToUpdate.setAddress(customer.getAddress());
			customerToUpdate.setDateOfBirth(customer.getDateOfBirth());
			customerToUpdate.setPhoneNumber(customer.getPhoneNumber());

			customerService.createCustomer(customerToUpdate);
			return ResponseEntity.ok(customerToUpdate);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
		if (customerService.getById(id).isPresent()) {
			return ResponseEntity.ok(customerService.getById(id).get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
