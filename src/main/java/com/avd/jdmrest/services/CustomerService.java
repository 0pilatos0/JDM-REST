package com.avd.jdmrest.services;

import com.avd.jdmrest.entities.Customer;

import java.util.Optional;

public interface CustomerService
{
	Iterable<Customer> getAll();
	Optional<Customer> getById(Long id);

	Customer createCustomer(Customer user);
}
