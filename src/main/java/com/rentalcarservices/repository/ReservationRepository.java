package com.rentalcarservices.repository;

import com.rentalcarservices.model.Client;
import com.rentalcarservices.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findAllByClient(Client client);
}
