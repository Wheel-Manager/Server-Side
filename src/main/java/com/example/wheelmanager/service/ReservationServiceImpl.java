package com.example.wheelmanager.service;

import com.example.wheelmanager.domain.model.Reservation;
import com.example.wheelmanager.domain.repository.ReservationRepository;
import com.example.wheelmanager.domain.repository.UserRepository;
import com.example.wheelmanager.domain.repository.VehicleRepository;
import com.example.wheelmanager.domain.service.ReservationService;
import com.example.wheelmanager.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VehicleRepository vehicleRepository;


    @Override
    public Page<Reservation> getAllReservations(Pageable pageable) {
        return reservationRepository.findAll(pageable);
    }

    @Override
    public Reservation getReservationsById(Long reservationId) {
        return reservationRepository.findById(reservationId).orElseThrow(() -> new ResourceNotFoundException("Reservation", "Id", reservationId));
    }

    @Override
    public Reservation createReservation(Long userId, Long vehicleId, Reservation reservation) {
        return userRepository.findById(userId).map(user -> {
            reservation.setUser(user);
            return vehicleRepository.findById(vehicleId).map(vehicle -> {
                reservation.setVehicle(vehicle);
                return reservationRepository.save(reservation);
            }).orElseThrow(() -> new ResourceNotFoundException("Vehicle", "Id", vehicleId));
        }).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
    }

    @Override
    public Reservation updateReservation(Long reservationId, Reservation reservationRequest) {
        return reservationRepository.findById(reservationId).map(reservation -> {
            reservation.setEndDate(reservationRequest.getEndDate())
                    .setStartDate(reservationRequest.getStartDate())
                    .setPrice(reservationRequest.getPrice());
            return reservationRepository.save(reservation);
        }).orElseThrow(() -> new ResourceNotFoundException("Reservation", "Id", reservationId));
    }

    @Override
    public ResponseEntity<?> deleteReservation(Long reservationId) {
        return reservationRepository.findById(reservationId).map(reservation -> {
            reservationRepository.delete(reservation);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Reservation", "Id", reservationId));
    }
}
