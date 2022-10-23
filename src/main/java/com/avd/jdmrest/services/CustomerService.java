package com.avd.jdmrest.services;

import com.avd.jdmrest.domain.Customer;

import java.util.Optional;

public interface CustomerService extends AbstractService
{
	/**
	 * Get all customers
	 * @return Iterable<Customer>
	 */
	Iterable<Customer> getAll();

	/**
	 * Get customer by id
	 * @param id customer id
	 * @return Optional<Customer>
	 */
	Optional<Customer> getById(Long id);

	/**
	 * Create a new customer
	 * @param customer customer
	 * @return Customer
	 */

	Customer createCustomer(Customer customer);

	/**
	 * Delete customer by id
	 * @param id customer id
	 * @return void
	 */

	void deleteById(Long id);
}
