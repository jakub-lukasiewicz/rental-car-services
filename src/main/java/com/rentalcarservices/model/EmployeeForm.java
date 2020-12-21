package com.rentalcarservices.model;

import lombok.Data;

@Data
public class EmployeeForm {

    private String name;
    private String lastName;
    private String position;

    private Long departmentId;
}
