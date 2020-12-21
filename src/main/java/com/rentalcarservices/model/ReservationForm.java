package com.rentalcarservices.model;

import lombok.Data;

@Data
public class ReservationForm {

    private String reservationDate;
    private Long clientId;
    private String carId;
    private String rentFrom;
    private String rentTo;

    private Long departmentFrom;
    private Long departmentTo;
}
