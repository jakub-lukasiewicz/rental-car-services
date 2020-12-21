package com.rentalcarservices.controller;

import com.rentalcarservices.model.Client;
import com.rentalcarservices.model.Department;
import com.rentalcarservices.model.Employee;
import com.rentalcarservices.model.EmployeeForm;
import com.rentalcarservices.service.DepartmentService;
import com.rentalcarservices.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/add")
    public String employeeAdd(Model model){
        model.addAttribute("newEmployee", new EmployeeForm());
        model.addAttribute("departments", departmentService.getDepartmentList());
        return "employee_new_form";
    }

    @PostMapping("/add")
    public String employeeAdd(EmployeeForm employeeForm) {

        employeeService.add(employeeForm);
        return "redirect:/employee/list";
    }
    @GetMapping("/list")
    public String employeeList(Model model){
        model.addAttribute("listOfEmployee", employeeService.getEmployeeList());
        return "employee_list";
    }

    @GetMapping("/delete/{employeeIdentifier}")
    public String deleteEmployee(@PathVariable Long employeeIdentifier){
        employeeService.deleteEmployeeById(employeeIdentifier);
        return "redirect:/employee/list";
    }
}
