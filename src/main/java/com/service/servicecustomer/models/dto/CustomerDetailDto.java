package com.service.servicecustomer.models.dto;

import lombok.Data;

@Data
public class CustomerDetailDto {

    private Long id;

    private String name;

    private String phone;

    private String email;

    private String address;

}