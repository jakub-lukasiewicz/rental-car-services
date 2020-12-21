package com.rentalcarservices.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReturnCarForm {
    private long employeeId;
    private long reservationId;
    private String notes;
    private double additionalFee;
    private double delayFee;
    private String returnDate;
}
