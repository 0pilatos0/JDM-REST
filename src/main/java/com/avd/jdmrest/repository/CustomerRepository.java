package com.avd.jdmrest.repository;

import com.avd.jdmrest.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long>
{
	Customer findCustomerById(Integer id);
}