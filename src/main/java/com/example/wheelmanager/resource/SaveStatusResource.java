package com.example.wheelmanager.resource;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SaveStatusResource {
    @NotNull
    @Size(max = 100)
    private String statusName;

    public String getStatusName() {
        return statusName;
    }

    public SaveStatusResource setStatusName(String statusName) {
        this.statusName = statusName;
        return this;
    }
}
