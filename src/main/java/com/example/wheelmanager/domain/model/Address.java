package com.example.wheelmanager.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "addresses")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Address extends AuditModel{
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private  Double latitude;

    @NotNull
    private  Double longitude;


    @NotNull
    @Lob
    private String description;

    public Long getId() {
        return id;
    }

    public Address setId(Long id) {
        this.id = id;
        return this;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Address setLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Address setLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Address setDescription(String description) {
        this.description = description;
        return this;
    }
}
