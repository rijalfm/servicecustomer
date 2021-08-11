package com.service.servicecustomer.repository;

import com.service.servicecustomer.models.entities.CustomerDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDetailRepo extends JpaRepository<CustomerDetail, Long> {
}
