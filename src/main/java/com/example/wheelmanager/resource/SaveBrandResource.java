package com.example.wheelmanager.resource;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SaveBrandResource {
    @NotNull
    @Size(max = 100)
    private String brandName;

    public String getBrandName() {
        return brandName;
    }

    public SaveBrandResource setBrandName(String brandName) {
        this.brandName = brandName;
        return this;
    }
}
