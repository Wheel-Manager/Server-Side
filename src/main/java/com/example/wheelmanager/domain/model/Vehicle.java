package com.example.wheelmanager.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "vehicles")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Vehicle extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NaturalId
    @Column(name = "vehicle_name", length = 100)
    private String vehicleName;

    @Lob
    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(name = "calification", nullable = false)
    private Integer calification;

    @Lob
    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "brand_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Brand brand;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "status_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vehicle_type_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private VehicleType vehicleType;


    public Long getId() {
        return id;
    }

    public Vehicle setId(Long id) {
        this.id = id;
        return this;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public Vehicle setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Vehicle setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getCalification() {
        return calification;
    }

    public Vehicle setCalification(Integer calification) {
        this.calification = calification;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Vehicle setDescription(String description) {
        this.description = description;
        return this;
    }
    public User getUser() {
        return user;
    }

    public Vehicle setUser(User user) {
        this.user = user;
        return this;
    }

    public Brand getBrand() {
        return brand;
    }

    public Vehicle setBrand(Brand brand) {
        this.brand = brand;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public Vehicle setStatus(Status status) {
        this.status = status;
        return this;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Vehicle setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
        return this;
    }
}
