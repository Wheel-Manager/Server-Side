package com.example.wheelmanager.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user_address")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserAddress extends AuditModel {
    @Id
    @Column(name = "user_address_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private boolean selected;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "address_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Address address;

    public Long getId() {
        return id;
    }

    public UserAddress setId(Long id) {
        this.id = id;
        return this;
    }

    public boolean isSelected() {
        return selected;
    }

    public UserAddress setSelected(boolean selected) {
        this.selected = selected;
        return this;
    }

    public User getUser() {
        return user;
    }

    public UserAddress setUser(User user) {
        this.user = user;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public UserAddress setAddress(Address address) {
        this.address = address;
        return this;
    }
}
