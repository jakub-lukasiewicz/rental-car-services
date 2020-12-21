package com.rentalcarservices.repository;

import com.rentalcarservices.model.Department;
import com.rentalcarservices.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findAllByDepartment(Department department);
}
