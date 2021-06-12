package com.example.wheelmanager.domain.repository;

import com.example.wheelmanager.domain.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}