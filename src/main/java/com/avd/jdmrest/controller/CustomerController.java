package com.avd.jdmrest.controller;

import com.avd.jdmrest.domain.Customer;
import com.avd.jdmrest.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/customer")
public class CustomerController extends AbstractController {

	private final CustomerService customerService;

	public CustomerController( CustomerService customerService ) {
		this.customerService = customerService;
	}

	/**
	 * retrieve all customers
	 * @return Iterable<Customer>
	 */
	@GetMapping
	public Iterable<Customer> getAllCustomers() {
		log("getAllCustomers");
		return customerService.getAll();
	}

	/**
	 * create a new customer
	 * @param customer customer
	 * @return Customer
	 */
	@PostMapping
	public Customer createCustomer(@Valid @RequestBody Customer customer) {
		log("createCustomer");
		return customerService.createCustomer(customer);
	}

	/**
	 * retrieves a customer by id
	 * @param id customer id
	 * @return ResponseEntity<Customer>
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCustomer(@Valid @PathVariable Long id) {
		if (customerService.getById(id).isPresent()) {
			log("deleteCustomer found", id);
			customerService.deleteById(id);
			return ResponseEntity.ok("Customer deleted");
		} else {
			log("deleteCustomer not found", id);
			return ResponseEntity.notFound().build();
		}
	}

	/**
	 * delete customer by id
	 * @param id customer id
	 * @return ResponseEntity<Customer>
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @Valid @RequestBody Customer customer) {
		if (customerService.getById(id).isPresent()) {
			log("updateCustomer found", id);
			Customer customerToUpdate = customerService.getById(id).get();
			customerToUpdate.setUsername(customer.getUsername());
			customerToUpdate.setAddress(customer.getAddress());
			customerToUpdate.setDateOfBirth(customer.getDateOfBirth());
			customerToUpdate.setPhoneNumber(customer.getPhoneNumber());

			customerService.createCustomer(customerToUpdate);
			return ResponseEntity.ok(customerToUpdate);
		} else {
			log("updateCustomer not found", id);
			return ResponseEntity.notFound().build();
		}
	}

	/**
	 * update customer by id
	 * @param id customer id
	 * @return ResponseEntity<Customer>
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
		if (customerService.getById(id).isPresent()) {
			log("getCustomerById found", id);
			return ResponseEntity.ok(customerService.getById(id).get());
		} else {
			log("getCustomerById not found", id);
			return ResponseEntity.notFound().build();
		}
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions( MethodArgumentNotValidException ex) {
		return handleErrors(ex);
	}
}
