package com.example.wheelmanager.resource;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SaveVehicleTypeResource {
    @NotNull
    @Size(max = 50)
    private String vehicleTypeName;

    public String getVehicleTypeName() {
        return vehicleTypeName;
    }

    public SaveVehicleTypeResource setVehicleTypeName(String vehicleTypeName) {
        this.vehicleTypeName = vehicleTypeName;
        return this;
    }
}
