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
    @Column(name= "start_date", nullable = false, updatable = false)
    @CreatedDate
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name= "end_date", nullable = false, updatable = false)
    @CreatedDate
    private Date endDate;

    @NotNull
    private Double offerPrice;


}
