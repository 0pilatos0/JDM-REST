package com.avd.jdmrest.controller;

import com.avd.jdmrest.repository.CustomerRepository;
import com.avd.jdmrest.services.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
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
        mockMvc.perform(delete("/customer/50"))
                .andExpect(status().isNotFound());

        mockMvc.perform(delete("/customer/1"))
                .andExpect(status().isOk());
    }

    @Test
    void updateCustomer() throws Exception {
        mockMvc.perform(put("/customer/50")
                .contentType("application/json")
                .content("{\n" +
                        "    \"name\": \"Jack\",\n" +
                        "    \"dateOfBirth\": \"1990-01-01\",\n" +
                        "    \"phoneNumber\": \"1234\",\n" +
                        "    \"email\": \"1234\"\n" +
                        "}"))
                .andExpect(status().isNotFound());


        mockMvc.perform(put("/customer/2")
                .contentType("application/json")
                .content("{\n" +
                        "    \"name\": \"Jack\",\n" +
                        "    \"dateOfBirth\": \"1990-01-01\",\n" +
                        "    \"phoneNumber\": \"1234\",\n" +
                        "    \"email\": \"1234\"\n" +
                        "}"))
                .andExpect(status().isOk());
    }

    @Test
    void getCustomerById() throws Exception {
        mockMvc.perform(get("/customer/60"))
                .andExpect(status().isNotFound());

        mockMvc.perform(get("/customer/3"))
                .andExpect(status().isOk());
    }
}