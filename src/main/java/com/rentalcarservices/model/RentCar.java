package com.rentalcarservices.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class RentCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Employee employee;
    @OneToOne
    private Reservation reservation;
    private String notes;

}
