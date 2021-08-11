package com.service.servicecustomer.controller;

import com.service.servicecustomer.models.dto.CustomerDto;
import com.service.servicecustomer.models.entities.Customer;
import com.service.servicecustomer.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customer")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    // Get all list of customer controller
    @GetMapping
    public List<CustomerDto> showAll() {
        return customerService.showAllCustomer();
    }

    // Create new customer controller
    @PostMapping
    public CustomerDto save(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    // Edit customer name controller
    @PutMapping
    public CustomerDto edit(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    // Delete (soft) customer controller
    // Hard delete is not recomended on this case
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        Customer customer = customerService.findById(id);
        if (customer==null) {
            return String.format("Customer with id %d not available", id);
        }
        customer.setIsDeleted(true);
        customerService.saveCustomer(customer);
        return String.format("Customer with id %d has deleted", id);
    }
}
