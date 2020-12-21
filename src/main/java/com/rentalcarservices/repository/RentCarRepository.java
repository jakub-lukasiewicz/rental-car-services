package com.rentalcarservices.repository;

import com.rentalcarservices.model.RentCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentCarRepository extends JpaRepository<RentCar, Long> {
}
