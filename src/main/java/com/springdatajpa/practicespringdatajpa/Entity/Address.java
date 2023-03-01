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
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_address")
public class Address {
    @Id
    @SequenceGenerator(
        name = "address_id",
        sequenceName = "address_id",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "address_id"
    )
    private Long addressId;
    private String address;
    private String mandal;
    private String postalCode;
    @OneToOne(
        cascade = CascadeType.ALL
    )
    @JoinColumn(
        name = "fk_city_id",
        referencedColumnName ="cityId"
    )
    private City city;
}
