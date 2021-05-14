package com.example.wheelmanager.resource;

import org.hibernate.annotations.NaturalId;

import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SaveVehicleResource {
    @NotNull
    @NaturalId
    @Size(max = 100)
    private String vehicleName;

    @NotNull
    @Lob
    private String imageUrl;

    @NotNull
    private Integer calification;

    @NotNull
    @Lob
    private String description;


    public String getVehicleName() {
        return vehicleName;
    }

    public SaveVehicleResource setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public SaveVehicleResource setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getCalification() {
        return calification;
    }

    public SaveVehicleResource setCalification(Integer calification) {
        this.calification = calification;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SaveVehicleResource setDescription(String description) {
        this.description = description;
        return this;
    }
}
