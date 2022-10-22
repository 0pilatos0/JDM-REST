package com.avd.jdmrest.services;

import com.avd.jdmrest.domain.Customer;
import com.avd.jdmrest.repository.CarListingRepository;
import com.avd.jdmrest.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    /**
     * @InheritDoc
     * @return Iterable<Customer>
     */
    @Override
    public Iterable<Customer> getAll() {
        return customerRepository.findAll();
    }

    /**
     * @InheritDoc
     * @param id customer id
     * @return Iterable<Customer>
     */
    @Override
    public Optional<Customer> getById(Long id) {
        return customerRepository.findById(id);
    }

    /**
     * @InheritDoc
     * @param customer customer
     * @return Optional<Customer>
     */

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    /**
     * @InheritDoc
     * @param id customer id
     * @return void
     */
    @Override
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }
}
