package com.avd.jdmrest.controller;

import com.avd.jdmrest.SpringTestConfiguration;
import com.avd.jdmrest.domain.Customer;
import com.avd.jdmrest.services.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { SpringTestConfiguration.class })
@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        customerService = mock(CustomerService.class);
    }

    @Test
    void deleteCustomer() throws Exception {
        mockMvc.perform(delete("/customer/1"))
                .andExpect(status().isNotFound());

        Customer customer = new Customer( "Jack",  LocalDate.of(1990, 1, 1), "1234", "1234");
        when(customerService.getById(1L)).thenReturn(Optional.of(customer));

        //TODO MOCK Contoller thingy to make this work
//        mockMvc.perform(delete("/customer/1"))
//                .andExpect(status().isOk());
    }

    @Test
    void updateCustomer() throws Exception {
        mockMvc.perform(put("/customer/1"))
                .andExpect(status().isNotFound());

        Customer customer = new Customer( "Jack",  LocalDate.of(1990, 1, 1), "1234", "1234");
        when(customerService.getById(1L)).thenReturn(Optional.of(customer));

        //TODO MOCK Contoller thingy to make this work
//        mockMvc.perform(put("/customer/1"))
//                .andExpect(status().isOk());
    }

    @Test
    void getCustomerById() throws Exception {
        mockMvc.perform(get("/customer/1"))
                .andExpect(status().isNotFound());

        Customer customer = new Customer( "Jack",  LocalDate.of(1990, 1, 1), "1234", "1234");
        when(customerService.getById(1L)).thenReturn(Optional.of(customer));

        //TODO MOCK Contoller thingy to make this work
//        mockMvc.perform(get("/customer/1"))
//                .andExpect(status().isOk());

    }
}