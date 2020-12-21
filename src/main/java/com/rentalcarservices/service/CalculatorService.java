package com.rentalcarservices.service;

import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;

@Service
public class CalculatorService {

    public double costCalc(long duration, double costOfDay){
        double cost = (int)duration * costOfDay;
        return cost;
    }

    public long durationCalc(LocalDate dateFrom, LocalDate dateTo){
        long duration = Duration.between(dateFrom.atStartOfDay(), dateTo.atStartOfDay()).toDays();
        return duration;
    }
}
