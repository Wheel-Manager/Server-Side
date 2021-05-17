package com.example.wheelmanager.domain.service;

import com.example.wheelmanager.domain.model.Reservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ReservationService {
    Page<Reservation> getAllReservations(Pageable pageable);
    Reservation getReservationsById(Long reservationId);
    Reservation createReservation(Long userId,Long vehicleId,Reservation reservation);
    Reservation updateReservation(Long reservationId,Reservation messageRequest);
    ResponseEntity<?> deleteReservation(Long reservationId);
}
