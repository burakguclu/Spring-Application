package com.burakguclu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.burakguclu.model.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long>{

}
