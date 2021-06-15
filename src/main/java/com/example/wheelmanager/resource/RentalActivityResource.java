package com.example.wheelmanager.resource;

import com.example.wheelmanager.domain.model.AuditModel;
import com.example.wheelmanager.domain.model.Offer;
import com.example.wheelmanager.domain.model.Reservation;

public class RentalActivityResource extends AuditModel {
    private Long id;

    private double price;

    private double commission;

    private double insurancePrice;

    private Reservation reservation;

    private Offer offer;

    public Long getId() {
        return id;
    }

    public RentalActivityResource setId(Long id) {
        this.id = id;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public RentalActivityResource setPrice(double price) {
        this.price = price;
        return this;
    }

    public double getCommission() {
        return commission;
    }

    public RentalActivityResource setCommission(double commission) {
        this.commission = commission;
        return this;
    }

    public double getInsurancePrice() {
        return insurancePrice;
    }

    public RentalActivityResource setInsurancePrice(double insurancePrice) {
        this.insurancePrice = insurancePrice;
        return this;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public RentalActivityResource setReservation(Reservation reservation) {
        this.reservation = reservation;
        return this;
    }

    public Offer getOffer() {
        return offer;
    }

    public RentalActivityResource setOffer(Offer offer) {
        this.offer = offer;
        return this;
    }
}
