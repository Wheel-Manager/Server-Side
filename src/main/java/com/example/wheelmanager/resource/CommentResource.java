package com.example.wheelmanager.resource;

import com.example.wheelmanager.domain.model.AuditModel;
import com.example.wheelmanager.domain.model.User;
import com.example.wheelmanager.domain.model.Vehicle;

import java.util.Date;

public class CommentResource extends AuditModel {
    private Long id;
    private String content;
    private Date publicationDate;
    private User user;
    private Vehicle vehicle;

    public Long getId() {
        return id;
    }

    public CommentResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getContent() {
        return content;
    }

    public CommentResource setContent(String content) {
        this.content = content;
        return this;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public CommentResource setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
        return this;
    }

    public User getUser() {
        return user;
    }

    public CommentResource setUser(User user) {
        this.user = user;
        return this;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public CommentResource setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        return this;
    }
}
