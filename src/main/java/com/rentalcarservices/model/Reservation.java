package com.rentalcarservices.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor

public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateReservation;

    @ManyToOne
    private Client client;
    @OneToOne
    private Car car;
    private LocalDate rentFrom;
    private LocalDate rentTo;
    @OneToOne
    private Department departmentFrom;
    @OneToOne
    private Department departmentTo;
    private double cost;
    private long duration;


}
