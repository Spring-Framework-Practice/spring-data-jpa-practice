package com.springdatajpa.practicespringdatajpa.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
public class City {
    @Id
    @SequenceGenerator(
    name = "city_sequence",
    sequenceName = "city_sequence",
    allocationSize = 1
    )
    @GeneratedValue(
        generator = "city_sequence",
        strategy = GenerationType.SEQUENCE
        
    )
    private Long cityId;
    private String cityName;
    @OneToOne(
        cascade = CascadeType.ALL
    )
    @JoinColumn(
        name = "fk_country_id",
        referencedColumnName = "countryId"
    )
    private Country country;
}
