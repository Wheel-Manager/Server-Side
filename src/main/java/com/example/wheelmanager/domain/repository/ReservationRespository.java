package com.example.wheelmanager.domain.repository;

import com.example.wheelmanager.domain.model.Reservation;
import com.example.wheelmanager.domain.model.UserAddress;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservationRespository  extends JpaRepository<Reservation,Long> {

}