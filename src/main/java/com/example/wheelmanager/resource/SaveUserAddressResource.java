package com.example.wheelmanager.resource;


import javax.validation.constraints.NotNull;

public class SaveUserAddressResource {
    @NotNull
    private boolean selected;

    public boolean isSelected() {
        return selected;
    }

    public SaveUserAddressResource setSelected(boolean selected) {
        this.selected = selected;
        return this;
    }
}
