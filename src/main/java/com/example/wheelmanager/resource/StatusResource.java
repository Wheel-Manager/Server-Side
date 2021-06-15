package com.example.wheelmanager.resource;

import com.example.wheelmanager.domain.model.AuditModel;

public class StatusResource extends AuditModel {

    private Long id;
    private String statusName;

    public Long getId() {
        return id;
    }

    public StatusResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getStatusName() {
        return statusName;
    }

    public StatusResource setStatusName(String statusName) {
        this.statusName = statusName;
        return this;
    }
}
