package com.rentalcarservices.service;

import com.rentalcarservices.model.Employee;
import com.rentalcarservices.model.RentCar;
import com.rentalcarservices.model.RentCarForm;
import com.rentalcarservices.model.Reservation;
import com.rentalcarservices.repository.EmployeeRepository;
import com.rentalcarservices.repository.RentCarRepository;
import com.rentalcarservices.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RentCarService {

    @Autowired
    private RentCarRepository rentCarRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ReservationRepository reservationRepository;

    public void add(RentCarForm rentCarForm){
        Employee employee = employeeRepository.findById(rentCarForm.getEmployeeId()).get();
        Reservation reservation = reservationRepository.findById(rentCarForm.getReservationId()).get();
        RentCar rentCar = new RentCar();
        rentCar.setEmployee(employee);
        rentCar.setReservation(reservation);
        rentCar.setNotes(rentCarForm.getNotes());

        rentCarRepository.save(rentCar);
    }

    public List<RentCar> getRentCarList(){
        return rentCarRepository.findAll();
    }


    public Optional<RentCar> findRentCar(Long id){
        return rentCarRepository.findById(id);
    }
}
