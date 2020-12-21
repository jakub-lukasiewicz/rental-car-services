package com.rentalcarservices.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private String street;
    private int streetNumber;
    private String postCode;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "department")
    private List<Car> availableList;



}
