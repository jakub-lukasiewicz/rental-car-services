package com.rentalcarservices.model;

import lombok.Data;

@Data
public class CarForm {

    private String brand;
    private String model;
    private String bodyType;
    private int productionYear;
    private String colour;
    private int mileage;
    private String status;
    private int costOfDay;

    private Long departmentId;

}
