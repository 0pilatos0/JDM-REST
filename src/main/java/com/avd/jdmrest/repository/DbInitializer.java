package com.avd.jdmrest.repository;

import com.avd.jdmrest.entities.Customer;
import org.springframework.stereotype.Component;

@Component
public class DbInitializer
{
	public DbInitializer(CustomerRepository customerRepository)
	{
		//super coole initialiser ding die er voor zorgt dat er iets van testdata is
		Customer customer1 = new Customer("John");
		Customer customer2 = new Customer("Jane");
		Customer customer3 = new Customer("Jack");

		customerRepository.save(customer1);
		customerRepository.save(customer2);
		customerRepository.save(customer3);
	}
}
