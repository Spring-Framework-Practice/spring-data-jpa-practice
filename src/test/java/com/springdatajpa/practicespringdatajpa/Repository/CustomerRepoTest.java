package com.springdatajpa.practicespringdatajpa.Repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springdatajpa.practicespringdatajpa.Entity.Address;
import com.springdatajpa.practicespringdatajpa.Entity.City;
import com.springdatajpa.practicespringdatajpa.Entity.Country;
import com.springdatajpa.practicespringdatajpa.Entity.Customer;
import java.util.List;
import java.util.Optional;
@SpringBootTest
public class CustomerRepoTest {
    @Autowired
    private CustomerRepository repository;
    @Test
    public void saveCustomer(){
       Country country=Country.builder().countryName("India").build();
       City city=City.builder().cityName("Chittoor").country(country)
       .build();
       Address address=Address.builder().address("6-371,Pillayar koil Street")
       .mandal("Chittoor").postalCode("517001").city(city)
       .build();
       Customer customer=Customer.builder().firstName("Zubair").lastName("basha")
       .email("zubair006@gmail.com").address(address).build();
       repository.save(customer);
            }
    @Test
    @DisplayName("This to get the list of Customer")
    public void getCustomDetials(){
        Optional<Customer> list=repository.findById(4L);
       
        list.ifPresent(user -> {
            System.out.println("User's name = " + user.getAddress().getCity());    
        });
    }
    @Test
    @DisplayName("Count the Customer")
    public void countTheCustomer(){
        Long count=repository.count();
        System.out.println(count);
    }
    @Test
    @DisplayName("To check whether the ID is present or not")
    public void checkTheRecordPresent(){
       boolean check=repository.existsById(4L);
       if(check)System.out.println("Exists");
       else System.out.println("Not Exists");
    }

    @Test
    @DisplayName("Derived Query")
    public void countUsingLastName(){
        Long count=repository.countByLastName("Basha");
        System.out.println(count);
    }
    @Test
    @DisplayName("Derived Query. Using lastName Order by FirstName")
    public void getCustomerDetailsUsingLastNameOrderByFirstName(){
        List<Customer> customer=repository.findByLastNameOrderByFirstNameAsc("Basha");
        System.out.println(customer);
    }
    @Test
    @DisplayName("Derived Query. Using the Property of the Class")
    public void getCustomerDetailsBasedOnAddress(){
        List<Customer> customer=repository.findByAddressMandal("Chittoor");
        System.out.println(customer);
    }
}
