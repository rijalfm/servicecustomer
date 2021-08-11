package com.service.servicecustomer.controller;

import com.service.servicecustomer.models.dto.CustomerDetailDto;
import com.service.servicecustomer.models.entities.Customer;
import com.service.servicecustomer.models.entities.CustomerDetail;
import com.service.servicecustomer.service.CustomerDetailServiceImpl;
import com.service.servicecustomer.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<CustomerDetailDto> showAll() {
        return customerDetailService.showAllWithDetail();
    }

    @GetMapping("/{id}/detail")
    public CustomerDetailDto findById(@PathVariable("id") Long id) {
        return customerDetailService.showDetailById(id);
    }

    @PostMapping("/detail")
    public CustomerDetailDto save(@RequestBody CustomerDetail customerDetail) {
        Customer customer = customerService.findById(customerDetail.getId());
        customerDetail.setCustomer(customer);
        return customerDetailService.saveDetail(customerDetail);
    }
}
