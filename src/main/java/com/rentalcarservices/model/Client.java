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
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastName;
    private String emailAddress;
    private String city;
    private String street;
    private int streetNumber;
    private String postCode;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "client")
    private List<Reservation> reservationList;


}
