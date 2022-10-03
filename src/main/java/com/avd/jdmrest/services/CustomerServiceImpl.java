package com.avd.jdmrest.services;

import com.avd.jdmrest.entities.Customer;
import com.avd.jdmrest.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService
{
	private final CustomerRepository customerRepository;

	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public Iterable<Customer> getAll() {
		return customerRepository.findAll();
	}

	@Override
	public Optional<Customer> getById(Long id) {
		return customerRepository.findById(id);
	}

	@Override
	public Customer createCustomer(Customer User) {
		return customerRepository.save(User);
	}
}
