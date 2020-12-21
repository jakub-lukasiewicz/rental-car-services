package com.rentalcarservices.controller;

import com.rentalcarservices.model.ReturnCarForm;
import com.rentalcarservices.service.EmployeeService;
import com.rentalcarservices.service.ReturnCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/returnCar")
public class ReturnCarController {

    @Autowired
    private ReturnCarService returnCarService;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/add")
    public String returnCarAdd(Model model, @RequestParam("reservationId") String reservationId){
        model.addAttribute("newReturnCar", new ReturnCarForm());
        model.addAttribute("employee", employeeService.getEmployeeList());
        model.addAttribute("reservationId", reservationId);
        return "return_car_form";
    }

    @PostMapping("/add")
    public String returnCarAdd(ReturnCarForm returnCarForm){
        returnCarService.add(returnCarForm);
        return "redirect:/returnCar/list";
    }

    @GetMapping("/list")
    public String returnCarList(Model model){
        model.addAttribute("listOfReturnCar", returnCarService.getReturnCarList());
        return "return_car_list";
    }
}
