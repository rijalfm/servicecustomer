package com.service.servicecustomer.service;

import com.service.servicecustomer.models.dto.CustomerDetailDto;
import com.service.servicecustomer.models.entities.CustomerDetail;

import java.util.List;

public interface CustomerDetailService {

    List<CustomerDetailDto> showAllWithDetail();

    CustomerDetailDto showDetailById(Long id);

    CustomerDetailDto saveDetail(CustomerDetail customerDetail);
}
