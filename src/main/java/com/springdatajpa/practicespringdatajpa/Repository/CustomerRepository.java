package com.springdatajpa.practicespringdatajpa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springdatajpa.practicespringdatajpa.Entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{
    
    //JPA Repository for Customer
    //added a new comment
}
