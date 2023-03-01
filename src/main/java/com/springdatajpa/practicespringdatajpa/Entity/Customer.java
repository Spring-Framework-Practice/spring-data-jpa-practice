package com.springdatajpa.practicespringdatajpa.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_customer")
public class Customer {
    @Id
    @SequenceGenerator(name = "customer_id", // this is the variable of the sequence Generator
            sequenceName = "customerId", // This is the name of the sequence Generator to refer in
            // generated value
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
    generator = "customer_id"

    )
    private Long customerId;
    private String firstName;
    private String lastName;
    private String email;
    //This is One to one relationship of Customer to Address
    //Customer will have the 1-1 relation ofAddress.
    @OneToOne(
        cascade = CascadeType.ALL
    )
    @JoinColumn(
        name = "fk_address_id",
        referencedColumnName = "addressId"
    )
    private Address address;
}
