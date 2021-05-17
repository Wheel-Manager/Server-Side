package com.example.wheelmanager.resource;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SaveStatusResource {
    @NotNull
    @Size(max = 100)
    private String name;

    public String getName() {
        return name;
    }

    public SaveStatusResource setName(String name) {
        this.name = name;
        return this;
    }
}
