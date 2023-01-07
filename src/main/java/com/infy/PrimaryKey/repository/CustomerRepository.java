package com.infy.PrimaryKey.repository;

import com.infy.PrimaryKey.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
