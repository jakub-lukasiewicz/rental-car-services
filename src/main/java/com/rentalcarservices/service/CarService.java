package com.rentalcarservices.service;

import com.rentalcarservices.model.Car;
import com.rentalcarservices.model.CarForm;
import com.rentalcarservices.model.Department;
import com.rentalcarservices.repository.CarRepository;
import com.rentalcarservices.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

        public void add(CarForm carForm){
        Department oddzial = departmentRepository.findById(carForm.getDepartmentId()).get();
        Car car = new Car();
        car.setDepartment(oddzial);
        car.setBrand(carForm.getBrand());
        car.setModel(carForm.getModel());
        car.setBodyType(carForm.getBodyType());
        car.setColour(carForm.getColour());
        car.setMileage(carForm.getMileage());
        car.setProductionYear(carForm.getProductionYear());
        car.setStatus(carForm.getStatus());
        car.setCostOfDay(carForm.getCostOfDay());

        carRepository.save(car);
    }

    public List<Car> getCarList() {
        return carRepository.findAll();
    }

    public void deleteCarById(Long carIdentifier) {
        carRepository.deleteById(carIdentifier);
    }

    public Optional<Car> findCar(Long id) {
        return carRepository.findById(id);
    }

}
