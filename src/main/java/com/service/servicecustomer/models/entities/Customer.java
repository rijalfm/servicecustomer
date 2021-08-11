package com.service.servicecustomer.models.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "first name is required")
    @Column(length = 20)
    private String firstName;

    @NotEmpty(message = "last name is required")
    @Column(length = 20)
    private String lastName;

    private Boolean isDeleted = false;

}
