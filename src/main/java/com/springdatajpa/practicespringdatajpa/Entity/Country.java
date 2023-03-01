package com.springdatajpa.practicespringdatajpa.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Country {
    @Id
    @SequenceGenerator(
        name="country_sequence",
        sequenceName="country_sequence",
        allocationSize=1
    )
    @GeneratedValue(
        generator="country_sequence",
        strategy=GenerationType.SEQUENCE
    )
   private Long countryId;
   private String countryName; 
}
