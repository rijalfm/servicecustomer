package com.service.servicecustomer.service;

import com.service.servicecustomer.models.dto.CustomerDto;
import com.service.servicecustomer.models.entities.Customer;
import com.service.servicecustomer.repository.CustomerRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Customer findById(Long id) {
        Optional<Customer> customer = customerRepo.findById(id);
        if (customer.isPresent()) {
            return customer.get();
        }

        return null;
    }

    @Override
    public CustomerDto saveCustomer(Customer customer) {

        Customer data = customerRepo.save(customer);
        CustomerDto result = modelMapper.map(data, CustomerDto.class);
        result.setName(data.getFirstName() + " " + data.getLastName());
        return result;

    }


    @Override
    public List<CustomerDto> showAllCustomer() {

        List<CustomerDto> customerDtoList = new ArrayList();

        for (Customer customer : customerRepo.findAll()) {
            CustomerDto data = modelMapper.map(customer, CustomerDto.class);
            data.setName(customer.getFirstName() + " " + customer.getLastName());
            customerDtoList.add(data);
        }

        return customerDtoList;
    }

    @Override
    public void deleteById(Long id) {
        customerRepo.deleteById(id);
    }
}
