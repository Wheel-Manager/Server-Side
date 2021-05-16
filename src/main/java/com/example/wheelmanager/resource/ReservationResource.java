package com.example.wheelmanager.resource;

import com.example.wheelmanager.domain.model.AuditModel;

import java.util.Date;

public class ReservationResource extends AuditModel {
    private Long id;
    private Date startDate;
    private Date endDate;
    private Double price;

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
}
