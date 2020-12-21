package com.rentalcarservices.model;

import lombok.Data;

@Data
public class ClientForm {

    private String name;
    private String lastName;
    private String emailAddress;
    private String city;
    private String street;
    private int streetNumber;
    private String postCode;

    private Long reservationId;
}
