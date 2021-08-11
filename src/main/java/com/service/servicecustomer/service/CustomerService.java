package com.service.servicecustomer.service;

import com.service.servicecustomer.models.dto.CustomerDto;
import com.service.servicecustomer.models.entities.Customer;

import java.util.List;

public interface CustomerService {

    Customer findById(Long id);

    CustomerDto saveCustomer(Customer customer);

    List<CustomerDto> showAllCustomer();

    void deleteById(Long id);
}
