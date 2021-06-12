package com.example.wheelmanager.domain.service;

import com.example.wheelmanager.domain.model.RentalActivity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface RentalActivityService {
    Page<RentalActivity> getAllRentalActivities(Pageable pageable);

    RentalActivity getRentalActivitiesById(Long rentalActivityId);

    RentalActivity createRentalActivities(Long reservationId, Long offerId, RentalActivity rentalActivity);

    RentalActivity updateRentalActivities(Long rentalActivityId, RentalActivity messageRequest);

    ResponseEntity<?> deleteRentalActivities(Long rentalActivityId);
}
