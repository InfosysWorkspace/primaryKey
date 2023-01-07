package com.infy.PrimaryKey.service;

import com.infy.PrimaryKey.dto.CustomerDTO;
import com.infy.PrimaryKey.entity.Customer;
import com.infy.PrimaryKey.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service(value="customerService")
@Transactional(readOnly = true)
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public Integer addCustomer(CustomerDTO customerDTO){
        Customer customer = new Customer();
        customer.setDateOfBirth(customerDTO.getDateOfBirth());
        customer.setEmailId(customerDTO.getEmailId());
        customer.setName(customer.getName());

        customerRepository.save(customer);
        return customer.getCustomerId();
    }
}
