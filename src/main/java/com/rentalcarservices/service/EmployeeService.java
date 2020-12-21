package com.rentalcarservices.service;

import com.rentalcarservices.model.Client;
import com.rentalcarservices.model.Department;
import com.rentalcarservices.model.Employee;
import com.rentalcarservices.model.EmployeeForm;
import com.rentalcarservices.repository.ClientRepository;
import com.rentalcarservices.repository.DepartmentRepository;
import com.rentalcarservices.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    public void add(EmployeeForm employeeForm) {
        Department oddzial = departmentRepository.findById(employeeForm.getDepartmentId()).get();
        Employee employee = new Employee();
        employee.setDepartment(oddzial);
        employee.setLastName(employeeForm.getLastName());
        employee.setName(employeeForm.getName());
        employee.setPosition(employeeForm.getPosition());

        employeeRepository.save(employee);

    }

    public List<Employee> getEmployeeList() {
        return employeeRepository.findAll();
    }

    public void deleteEmployeeById(Long employeeIdentifier) {
        employeeRepository.deleteById(employeeIdentifier);
    }

    public Optional<Employee> findEmployee(Long id) {
        return employeeRepository.findById(id);
    }


    // metoda dla department_management wyciagajaca pracownikow z danego oddzialu


    public List<Employee> findByDepartment(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).isPresent() ? departmentRepository.findById(departmentId).get() : null;
        if (department != null) {
            return employeeRepository.findAllByDepartment(department);
        }
        return new ArrayList<>();
    }
}
