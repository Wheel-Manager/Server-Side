package com.example.wheelmanager.domain.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "rental_activities")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class RentalActivity extends AuditModel{
    @Id
    @Column(name = "rental_activity_id")
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private double price;

    @NotNull
    private double commission;

    @NotNull
    private double insurancePrice;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "reservation_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Reservation reservation;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "offer_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Offer offer;

    public Long getId() {
        return id;
    }

    public RentalActivity setId(Long id) {
        this.id = id;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public RentalActivity setPrice(double price) {
        this.price = price;
        return this;
    }

    public double getCommission() {
        return commission;
    }

    public RentalActivity setCommission(double commission) {
        this.commission = commission;
        return this;
    }

    public double getInsurancePrice() {
        return insurancePrice;
    }

    public RentalActivity setInsurancePrice(double insurancePrice) {
        this.insurancePrice = insurancePrice;
        return this;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public RentalActivity setReservation(Reservation reservation) {
        this.reservation = reservation;
        return this;
    }

    public Offer getOffer() {
        return offer;
    }

    public RentalActivity setOffer(Offer offer) {
        this.offer = offer;
        return this;
    }
}
