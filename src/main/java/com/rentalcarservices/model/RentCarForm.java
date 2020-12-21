package com.rentalcarservices.model;
import lombok.Data;

@Data
public class RentCarForm {

    private Long reservationId;
    private String notes;
    private Long employeeId;

}
