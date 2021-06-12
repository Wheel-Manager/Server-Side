package com.example.wheelmanager.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "offers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Offer extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "offer_name", length = 50)
    private String offerName;

    @NotNull
    @Lob
    private String description;

    @NotNull
    @Column(name = "image_url")
    @Lob
    private String imageUrl;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_date", nullable = false, updatable = false)
    @CreatedDate
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_date", nullable = false, updatable = false)
    @CreatedDate
    private Date endDate;

    @NotNull
    @Column(name = "offer_price")
    private Double offerPrice;

    public Long getId() {
        return id;
    }

    public Offer setId(Long id) {
        this.id = id;
        return this;
    }

    public String getOfferName() {
        return offerName;
    }

    public Offer setOfferName(String offerName) {
        this.offerName = offerName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Offer setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Offer setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Offer setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Offer setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public Double getOfferPrice() {
        return offerPrice;
    }

    public Offer setOfferPrice(Double offerPrice) {
        this.offerPrice = offerPrice;
        return this;
    }
}
