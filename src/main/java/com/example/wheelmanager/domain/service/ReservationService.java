package com.example.wheelmanager.domain.service;

import com.example.wheelmanager.domain.model.Reservation;
import com.example.wheelmanager.domain.model.UserAddress;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ReservationService {
    Page<Reservation> getAllReservationsByUserId(Long userId, Pageable pageable);
    Page<Reservation> getAllReservationsByVehicleId(Long vehicleId, Pageable pageable);
    Reservation getReservationsByIdByUserIdAndAddressId(Long userId, Long vehicleId, Long reservationId);
    Reservation createReservation(Long userId,Long vehicleId,Reservation reservation);
    Reservation updateReservation(Long userId,Long vehicleId,Long reservationId,Reservation messageRequest);
    ResponseEntity<?> deleteReservation(Long userId, Long vehicleId, Long reservationId);
}
