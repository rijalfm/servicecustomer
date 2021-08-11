package com.service.servicecustomer.repository;

import com.service.servicecustomer.models.entities.CustomerDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerDetailRepo extends JpaRepository<CustomerDetail, Long> {

    @Query(value = "SELECT cd, c FROM CustomerDetail  cd INNER JOIN cd.customer c WHERE c.isDeleted = false ORDER BY c.id")
    List<CustomerDetail> findAllNotDeleted();
}
