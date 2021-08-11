package com.service.servicecustomer.service;

import com.service.servicecustomer.models.dto.CustomerDetailDto;
import com.service.servicecustomer.models.entities.CustomerDetail;
import com.service.servicecustomer.repository.CustomerDetailRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class CustomerDetailServiceImpl implements CustomerDetailService{

    @Autowired
    private CustomerDetailRepo customerDetailRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CustomerDetailDto showDetailById(Long id) {
        Optional<CustomerDetail> customerDetail = customerDetailRepo.findById(id);
        if (customerDetail.isPresent()) {
            CustomerDetailDto data = modelMapper.map(customerDetail.get(), CustomerDetailDto.class);
            data.setName(customerDetail.get().getCustomer().getFirstName() + " " + customerDetail.get().getCustomer().getLastName());

            return data;
        }
        return null;
    }

    @Override
    public CustomerDetailDto saveDetail(CustomerDetail customerDetail) {
        System.out.println(customerDetail.toString());
        CustomerDetail customer = customerDetailRepo.save(customerDetail);
        CustomerDetailDto customerDetailDto = modelMapper.map(customer, CustomerDetailDto.class);
        customerDetailDto.setName(customer.getCustomer().getFirstName() + " " + customer.getCustomer().getLastName());

        return customerDetailDto;
    }
}
