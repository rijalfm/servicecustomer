package com.service.servicecustomer.controller;

import com.service.servicecustomer.models.dto.CustomerDetailDto;
import com.service.servicecustomer.models.entities.Customer;
import com.service.servicecustomer.models.entities.CustomerDetail;
import com.service.servicecustomer.service.CustomerDetailServiceImpl;
import com.service.servicecustomer.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customer")
public class CustomerDetailController {

    @Autowired
    private CustomerDetailServiceImpl customerDetailService;

    @Autowired
    private CustomerServiceImpl customerService;

    @GetMapping("all/detail")
    public ResponseEntity showAll() {

        return ResponseEntity.ok(customerDetailService.showAllWithDetail());
    }

    @GetMapping("/{id}/detail")
    public ResponseEntity findById(@PathVariable("id") Long id) {

        return ResponseEntity.ok(customerDetailService.showDetailById(id));
    }

    @PostMapping("/detail")
    public ResponseEntity save(@RequestBody CustomerDetail customerDetail) {
        Customer customer = customerService.findById(customerDetail.getId());
        customerDetail.setCustomer(customer);
        return ResponseEntity.ok(customerDetailService.saveDetail(customerDetail));
    }
}
