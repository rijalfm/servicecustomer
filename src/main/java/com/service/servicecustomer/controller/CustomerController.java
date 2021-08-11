package com.service.servicecustomer.controller;

import com.service.servicecustomer.models.dto.CustomerDto;
import com.service.servicecustomer.models.entities.Customer;
import com.service.servicecustomer.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customer")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    // Get all list of customer controller
    @GetMapping
    public ResponseEntity showAll() {
        return ResponseEntity.ok(customerService.showAllCustomer());
    }

    // Create new customer controller
    @PostMapping
    public ResponseEntity save(@RequestBody Customer customer) {

        return ResponseEntity.ok(customerService.saveCustomer(customer));
    }

    // Edit customer name controller
    @PutMapping
    public ResponseEntity edit(@RequestBody Customer customer) {

        return ResponseEntity.ok(customerService.saveCustomer(customer));
    }

    // Delete (soft) customer controller
    // Hard delete is not recomended on this case
    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Long id) {
        Customer customer = customerService.findById(id);
        if (customer==null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(String.format("Customer with id %d not available", id));
        }
        customer.setIsDeleted(true);
        customerService.saveCustomer(customer);
        return ResponseEntity.ok(String.format("Customer with id %d has deleted", id));
    }
}
