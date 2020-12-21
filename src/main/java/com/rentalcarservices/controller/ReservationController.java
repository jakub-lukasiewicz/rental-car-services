package com.rentalcarservices.controller;

import com.rentalcarservices.model.ReservationForm;
import com.rentalcarservices.service.ClientService;
import com.rentalcarservices.service.DepartmentService;
import com.rentalcarservices.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/add")
    public String reservationAdd(Model model) {
        model.addAttribute("newReservation", new ReservationForm());
        model.addAttribute("departments", departmentService.getDepartmentList());

        return "reservation_new_form";
    }

    @PostMapping("/add")
    public String reservationAdd(ReservationForm reservationForm) {
        reservationService.add(reservationForm);
        return "redirect:/reservation/list";
    }

    @GetMapping("/list")
    public String reservationList(Model model) {
        model.addAttribute("listOfReservation", reservationService.getReservationList());
        return "reservation_list";
    }

    @GetMapping("/delete/{reservationIdentifier}")
    public String deleteReservation(@PathVariable Long reservationIdentifier) {
        reservationService.deleteReservationById(reservationIdentifier);
        return "redirect:/reservation/list";
    }

}