package com.service.servicecustomer.repository;

import com.service.servicecustomer.models.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
