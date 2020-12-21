package com.rentalcarservices.controller;
import com.rentalcarservices.model.Department;
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
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/add")
    public String departmentAdd(Model model){
        model.addAttribute("newDepartment", new Department());
        return"department_new_form";
    }
    @PostMapping("/add")
    public String departmentAdd(Department department){
        departmentService.add(department);
        return"redirect:/department/list";
    }
    @GetMapping("/list")
    public String departmentList(Model model){
        model.addAttribute("listOfDepartment",departmentService.getDepartmentList());
        return "department_list";
    }
    @GetMapping("/delete/{departmentIdentifier}")
    public String deleteDepartment (@PathVariable Long departmentIdentifier){
        departmentService.deleteDepartmentById(departmentIdentifier);
        return "redirect:/department/list";
    }
    @GetMapping("/management/{departmentIdentifier}")
    public String departmentManagement(Model model, @PathVariable Long departmentIdentifier){
        model.addAttribute("listOfEmployeeForDepartment", employeeService.findByDepartment(departmentIdentifier));
        return "department_management";
    }
}
