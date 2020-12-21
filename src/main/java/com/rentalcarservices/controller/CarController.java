package com.rentalcarservices.controller;

import com.rentalcarservices.model.Car;
import com.rentalcarservices.model.CarForm;
import com.rentalcarservices.service.CarService;
import com.rentalcarservices.service.DepartmentService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/add")
    public String carAdd(Model model){
        model.addAttribute("newCar", new CarForm());
        model.addAttribute("departments", departmentService.getDepartmentList());
        return "car_new_form";
    }
    @PostMapping("/add")
    public String carAdd(CarForm carForm){
        carService.add(carForm);
        return "redirect:/car/list";

    }
    @GetMapping("/list")
    public String carList(Model model){
        model.addAttribute("listOfCar", carService.getCarList());
        return "car_list";
    }
    @GetMapping("/delete/{carIdentifier}")
    public String deleteCar(@PathVariable Long carIdentifier){
        carService.deleteCarById(carIdentifier);
        return "redirect:/car/list";
    }

}
