package com.example.wheelmanager.resource;

import com.example.wheelmanager.domain.model.AuditModel;
import com.example.wheelmanager.domain.model.User;
import com.example.wheelmanager.domain.model.Vehicle;

import java.util.Date;

public class ReservationResource extends AuditModel {
    private Long id;

    private Date startDate;

    private Date endDate;

    private Double price;

    private User user;

    private Vehicle vehicle;

    public Long getId() {
        return id;
    }

    public ReservationResource setId(Long id) {
        this.id = id;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public ReservationResource setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public ReservationResource setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public ReservationResource setPrice(Double price) {
        this.price = price;
        return this;
    }

    public User getUser() {
        return user;
    }

    public ReservationResource setUser(User user) {
        this.user = user;
        return this;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ReservationResource setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        return this;
    }
}
