package com.example.wheelmanager.resource;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class SaveSubscriptionResource {
    @NotNull
    @Lob
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    @CreatedDate
    private Date startDate;

    @NotNull
    private double price;

    public String getDescription() {
        return description;
    }

    public SaveSubscriptionResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public SaveSubscriptionResource setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public SaveSubscriptionResource setPrice(double price) {
        this.price = price;
        return this;
    }
}