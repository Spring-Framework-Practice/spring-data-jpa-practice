package com.springdatajpa.practicespringdatajpa.Repository;
import com.springdatajpa.practicespringdatajpa.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.springdatajpa.practicespringdatajpa.Entity.Customer;
@Repository

public interface CustomerRepository extends JpaRepository<Customer,Long>{
   //Derived Query
   long countByLastName(String lastName);
   List<Customer> findByLastNameOrderByFirstNameAsc(String lastName);
   //traverse by property
   List<Customer> findByAddressMandal(String mandal);
}
