package com.rentalcarservices.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Year;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private String bodyType;
    private int productionYear;
    private String colour;
    private int mileage;
    private String status;
    private double costOfDay;

    @ManyToOne()
    private Department department;


    public void setDepartment(Department oddzial) {
    }
}
