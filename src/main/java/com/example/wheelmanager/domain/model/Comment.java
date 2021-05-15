package com.example.wheelmanager.domain.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "coments")
public class Comment extends AuditModel{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Lob
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name= "publication_date", nullable = false, updatable = false)
    @CreatedDate
    private Date publicationDate;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "user_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "vehicle_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Vehicle vehicle;

    public Long getId() {
        return id;
    }

    public Comment setId(Long id) {
        this.id = id;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Comment setContent(String content) {
        this.content = content;
        return this;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public Comment setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Comment setUser(User user) {
        this.user = user;
        return this;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Comment setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        return this;
    }
}
