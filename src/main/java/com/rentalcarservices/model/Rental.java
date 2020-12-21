package com.rentalcarservices.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.print.DocFlavor;
import java.net.URL;
import java.util.List;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rentalName;
    private URL url;
    private String emailAddress;
    private String phoneNumber;
    private String city;
    private String street;
    private int streetNumber;
    private String postCode;

    @OneToMany()
    private List<Department> departmentList;


}
