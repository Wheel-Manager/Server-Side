package com.example.wheelmanager.resource;

import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class SaveUserResource {
    @NotNull
    @Size(max = 50)
    private String userName;
    @NotNull
    @Size(max = 25)
    private String password;
    @NotNull
    @Size(max = 150)
    private String email;
    @NotNull
    @Size(max = 25)
    private String name;
    @NotNull
    @Size(max = 30)
    private String lastName;
    @NotNull
    @Lob
    private String imageUrl;
    @NotNull
    private Long dni;
    @NotNull
    @Size(max = 50)
    private String gender;
    @NotNull
    private Date birthDay;

    public String getUserName() {
        return userName;
    }

    public SaveUserResource setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SaveUserResource setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public SaveUserResource setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getName() {
        return name;
    }

    public SaveUserResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public SaveUserResource setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public SaveUserResource setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Long getDni() {
        return dni;
    }

    public SaveUserResource setDni(Long dni) {
        this.dni = dni;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public SaveUserResource setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public SaveUserResource setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
        return this;
    }
}
