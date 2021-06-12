package com.example.wheelmanager.resource;

import com.example.wheelmanager.domain.model.Address;
import com.example.wheelmanager.domain.model.AuditModel;
import com.example.wheelmanager.domain.model.User;

public class UserAddressResource extends AuditModel {
    private Long id;

    private boolean selected;

    private User user;

    private Address address;

    public Long getId() {
        return id;
    }

    public UserAddressResource setId(Long id) {
        this.id = id;
        return this;
    }

    public boolean isSelected() {
        return selected;
    }

    public UserAddressResource setSelected(boolean selected) {
        this.selected = selected;
        return this;
    }

    public User getUser() {
        return user;
    }

    public UserAddressResource setUser(User user) {
        this.user = user;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public UserAddressResource setAddress(Address address) {
        this.address = address;
        return this;
    }
}
