package com.example.wheelmanager.resource;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class SaveOfferResource {
    @NotNull
    @Size(max = 50)
    private String name;

    @NotNull
    @Lob
    private String description;

    @NotNull
    @Lob
    private String imageUrl;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    @CreatedDate
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date endDate;

    @NotNull
    private Double offerPrice;

    public String getName() {
        return name;
    }

    public SaveOfferResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SaveOfferResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public SaveOfferResource setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public SaveOfferResource setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public SaveOfferResource setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public Double getOfferPrice() {
        return offerPrice;
    }

    public SaveOfferResource setOfferPrice(Double offerPrice) {
        this.offerPrice = offerPrice;
        return this;
    }
}
