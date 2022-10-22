package com.avd.jdmrest.services;

import com.avd.jdmrest.domain.Customer;

import java.util.Optional;

public interface CustomerService
{
	Iterable<Customer> getAll();
	Optional<Customer> getById(Long id);

	Customer createCustomer(Customer user);

	void deleteById(Long id);
}
