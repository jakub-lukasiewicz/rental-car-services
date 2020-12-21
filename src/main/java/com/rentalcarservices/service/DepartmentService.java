package com.rentalcarservices.service;
import com.rentalcarservices.model.Car;
import com.rentalcarservices.model.Department;
import com.rentalcarservices.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public void add(Department department){
        departmentRepository.save(department);
    }
    public List<Department> getDepartmentList(){
        return  departmentRepository.findAll();
    }
    public void deleteDepartmentById(Long departmentIdentifier){
        departmentRepository.deleteById(departmentIdentifier);
    }
    public Optional<Department> findDepartment(Long id){
        return departmentRepository.findById(id);
    }

}
