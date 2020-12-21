package com.rentalcarservices.service;

import com.rentalcarservices.model.*;
import com.rentalcarservices.repository.ClientRepository;
import com.rentalcarservices.repository.DepartmentRepository;
import com.rentalcarservices.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private CarService carService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CalculatorService calculatorService;

    public void add(ReservationForm reservationForm) {
        Reservation reservation = new Reservation();

        Client client = clientService.findClient((reservationForm.getClientId())).get();
        reservation.setClient(client);
        Car car = carService.findCar(Long.parseLong(reservationForm.getCarId())).get();
        reservation.setCar(car);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String dateStr = reservationForm.getReservationDate();
        LocalDate tempDate = LocalDate.parse(dateStr, dtf);
        reservation.setDateReservation(tempDate);

        dateStr = reservationForm.getRentFrom();
        tempDate = LocalDate.parse(dateStr, dtf);
        reservation.setRentFrom(tempDate);

        dateStr = reservationForm.getRentTo();
        tempDate = LocalDate.parse(dateStr, dtf);
        reservation.setRentTo(tempDate);

        Department department;
        department = departmentRepository.findById(reservationForm.getDepartmentFrom()).get();
        reservation.setDepartmentFrom(department);
        department = departmentRepository.findById(reservationForm.getDepartmentTo()).get();
        reservation.setDepartmentTo(department);

        reservation.setDuration(calculatorService.durationCalc(reservation.getRentFrom(), reservation.getRentTo()) + 1);
        reservation.setCost(calculatorService.costCalc(reservation.getDuration(), reservation.getCar().getCostOfDay()));

        reservationRepository.save(reservation);
    }

    public List<Reservation> getReservationList() {
        return reservationRepository.findAll();
    }

    public void deleteReservationById(Long reservationIdentifier) {
        reservationRepository.deleteById(reservationIdentifier);
    }

    public Optional<Reservation> findRentCar(Long id) {
        return reservationRepository.findById(id);
    }

    public List<Reservation> findByClient(Long clientId) {
        Client client = clientRepository.findById(clientId).isPresent() ? clientRepository.findById(clientId).get() : null;
        if (client != null) {
            return reservationRepository.findAllByClient(client);
        }
        return new ArrayList<>();
    }


}


