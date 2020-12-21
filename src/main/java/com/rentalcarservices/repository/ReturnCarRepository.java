package com.rentalcarservices.repository;

import com.rentalcarservices.model.ReturnCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnCarRepository extends JpaRepository<ReturnCar, Long> {
}
