package com.example.wheelmanager.service;

import com.example.wheelmanager.domain.model.RentalActivity;
import com.example.wheelmanager.domain.repository.*;
import com.example.wheelmanager.domain.service.RentalActivityService;
import com.example.wheelmanager.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RentalActivityServiceImpl implements RentalActivityService {
    @Autowired
    private RentalActivityRepository rentalActivityRepository;

    @Autowired
    private ReservationRespository reservationRespository;

    @Autowired
    private OfferRepository offerRepository;

    @Override
    public Page<RentalActivity> getAllRentalActivities(Pageable pageable) {
        return rentalActivityRepository.findAll(pageable);
    }

    @Override
    public RentalActivity getRentalActivitiesById(Long rentalActivityId){
        return rentalActivityRepository.findById(rentalActivityId).orElseThrow(() -> new ResourceNotFoundException("RentalActivity", "Id",rentalActivityId));
    }

    @Override
    public RentalActivity createRentalActivities(Long reservationId, Long offerId, RentalActivity rentalActivity) {
        return reservationRespository.findById(reservationId).map(reservation->{
            rentalActivity.setReservation(reservation);
            return offerRepository.findById(offerId).map(offer -> {
                rentalActivity.setOffer(offer);
                return rentalActivityRepository.save(rentalActivity);
            }).orElseThrow(()->new ResourceNotFoundException("Offer","Id", offerId));
        }).orElseThrow(()->new ResourceNotFoundException("Reservation","Id", reservationId));
    }

    @Override
    public RentalActivity updateRentalActivities(Long rentalActivityId, RentalActivity rentalActivityRequest) {
        RentalActivity rentalActivity = rentalActivityRepository.findById(rentalActivityId)
                .orElseThrow(() -> new ResourceNotFoundException("RentalActivity", "Id",rentalActivityId));
        return  rentalActivityRepository.save(
        rentalActivity.setPrice(rentalActivityRequest.getPrice())
        .setCommission(rentalActivityRequest.getCommission())
        .setInsurancePrice(rentalActivityRequest.getInsurancePrice()));
    }

    @Override
    public ResponseEntity<?> deleteRentalActivities(Long rentalActivityId) {
        RentalActivity rentalActivity = rentalActivityRepository.findById(rentalActivityId)
                .orElseThrow(() -> new ResourceNotFoundException("RentalActivity", "Id",rentalActivityId));
        rentalActivityRepository.delete(rentalActivity);
        return ResponseEntity.ok().build();
    }
}
