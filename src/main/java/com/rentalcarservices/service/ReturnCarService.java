package com.rentalcarservices.service;

import com.rentalcarservices.model.Employee;
import com.rentalcarservices.model.Reservation;
import com.rentalcarservices.model.ReturnCar;
import com.rentalcarservices.model.ReturnCarForm;
import com.rentalcarservices.repository.EmployeeRepository;
import com.rentalcarservices.repository.ReservationRepository;
import com.rentalcarservices.repository.ReturnCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class ReturnCarService {

    @Autowired
    private ReturnCarRepository returnCarRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CalculatorService calculatorService;

    public void add(ReturnCarForm returnCarForm){
        Reservation reservation = reservationRepository.findById(returnCarForm.getReservationId()).get();
        Employee employee = employeeRepository.findById(returnCarForm.getEmployeeId()).get();
        ReturnCar returnCar = new ReturnCar();
        returnCar.setEmployee(employee);
        returnCar.setReservation(reservation);
        returnCar.setAdditionalFee(returnCarForm.getAdditionalFee());
        returnCar.setNotes(returnCarForm.getNotes());

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateStr = returnCarForm.getReturnDate();
        LocalDate tempDate = LocalDate.parse(dateStr, dtf);
        returnCar.setReturnDate(tempDate);

        long duration = calculatorService.durationCalc(reservation.getRentTo(), returnCar.getReturnDate());
        if (duration > 0){
            returnCar.setDelayFee(calculatorService.costCalc(duration, reservation.getCar().getCostOfDay()));
        } else {
            returnCar.setDelayFee(0);
        }

        returnCar.setTotalCost(reservation.getCost() + returnCar.getAdditionalFee() + returnCar.getDelayFee());

//        List tempList = reservation.getDepartmentTo().getAvailableList();
//        tempList.add(reservation.getCar());
//        reservation.getDepartmentTo().setAvailableList(tempList);

        returnCarRepository.save(returnCar);
    }

    public List<ReturnCar> getReturnCarList(){
        return returnCarRepository.findAll();
    }

    public Optional<ReturnCar> findReturnCar(Long id){
        return returnCarRepository.findById(id);
    }
}
