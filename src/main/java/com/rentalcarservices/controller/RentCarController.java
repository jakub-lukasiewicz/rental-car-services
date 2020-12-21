package com.rentalcarservices.controller;

import com.rentalcarservices.model.RentCarForm;
import com.rentalcarservices.service.EmployeeService;
import com.rentalcarservices.service.RentCarService;
import com.rentalcarservices.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/rentCar")
public class RentCarController {

    @Autowired
    private RentCarService rentCarService;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/add")
    public String rentCarAdd(Model model, @RequestParam ("dateFrom") String dateFrom,
                             @RequestParam("dateReservation") String dateReservation,
                             @RequestParam("reservationId") String reservationId,
                             @RequestParam("cost") String cost){
        model.addAttribute("newRentCar", new RentCarForm());
        model.addAttribute("employee", employeeService.getEmployeeList());
        model.addAttribute("dateFrom", dateFrom);
        model.addAttribute("dateReservation", dateReservation);
        model.addAttribute("reservationId", reservationId);
        model.addAttribute("cost", cost);
        return "rent_car_form";
    }

    @PostMapping("/add")
    public String rentCarAdd(RentCarForm rentCarForm){
        rentCarService.add(rentCarForm);
        return "redirect:/rentCar/list";

    }

    @GetMapping("/list")
    public String rentCarList(Model model){
        model.addAttribute("listOfRentCar", rentCarService.getRentCarList());
        return "rent_car_list";
    }





}
