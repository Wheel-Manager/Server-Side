package com.example.wheelmanager.resource;

import com.example.wheelmanager.domain.model.AuditModel;

import java.util.Date;

public class OfferResource extends AuditModel {
    private Long id;

    private String offerName;

    private String description;

    private String imageUrl;

    private Date startDate;

    private Date endDate;

    private Double offerPrice;

    public Long getId() {
        return id;
    }

    public OfferResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getOfferName() {
        return offerName;
    }

    public OfferResource setOfferName(String offerName) {
        this.offerName = offerName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferResource setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public OfferResource setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public OfferResource setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public Double getOfferPrice() {
        return offerPrice;
    }

    public OfferResource setOfferPrice(Double offerPrice) {
        this.offerPrice = offerPrice;
        return this;
    }
}
