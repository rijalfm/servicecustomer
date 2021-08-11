package com.service.servicecustomer.service;

import com.service.servicecustomer.models.dto.CustomerDetailDto;
import com.service.servicecustomer.models.entities.CustomerDetail;

public interface CustomerDetailService {

    CustomerDetailDto showDetailById(Long id);

    CustomerDetailDto saveDetail(CustomerDetail customerDetail);
}
