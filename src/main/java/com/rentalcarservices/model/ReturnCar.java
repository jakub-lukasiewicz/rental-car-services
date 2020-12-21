package com.rentalcarservices.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class ReturnCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Employee employee;
    @OneToOne
    private Reservation reservation;
    private String notes;
    private double additionalFee;
    private double delayFee;
    private LocalDate returnDate;
    private double totalCost;

}