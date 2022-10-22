package com.avd.jdmrest.services;

import com.avd.jdmrest.domain.Customer;

import java.util.Optional;

public interface CustomerService
{
	/**
	 * Get all customers
	 * @return Iterable<Customer>
	 */
	Iterable<Customer> getAll();

	/**
	 * Get customer by id
	 * @param id
	 * @return Optional<Customer>
	 */
	Optional<Customer> getById(Long id);

	/**
	 * Create a new customer
	 * @param customer
	 * @return Customer
	 */

	Customer createCustomer(Customer customer);

	/**
	 * Delete customer by id
	 * @param id
	 * @return void
	 */

	void deleteById(Long id);
}
