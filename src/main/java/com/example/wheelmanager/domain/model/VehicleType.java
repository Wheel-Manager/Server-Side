package com.example.wheelmanager.domain.model;

import javax.persistence.*;

@Entity
@Table(name = "vehicle_types")
public class VehicleType extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type_name",nullable = false,length = 50)
    private String typeName;

    public Long getId() {
        return id;
    }

    public VehicleType setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTypeName() {
        return typeName;
    }

    public VehicleType setTypeName(String typeName) {
        this.typeName = typeName;
        return this;
    }
}
