package com.springdatajpa.practicespringdatajpa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springdatajpa.practicespringdatajpa.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
    
}
