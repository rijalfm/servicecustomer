package com.service.servicecustomer.models.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "customer_detail")
public class CustomerDetail {

    @Id
    @Column(name = "customer_id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @PrimaryKeyJoinColumn(name = "customer_id")
    private Customer customer;

    private String phone;

    private String email;

    private String address;

}