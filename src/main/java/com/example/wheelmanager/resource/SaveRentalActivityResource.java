package com.example.wheelmanager.resource;


import javax.validation.constraints.NotNull;

public class SaveRentalActivityResource {
    @NotNull
    private double price;

    @NotNull
    private double commission;

    @NotNull
    private double insurancePrice;

    public double getPrice() {
        return price;
    }

    public SaveRentalActivityResource setPrice(double price) {
        this.price = price;
        return this;
    }

    public double getCommission() {
        return commission;
    }

    public SaveRentalActivityResource setCommission(double commission) {
        this.commission = commission;
        return this;
    }

    public double getInsurancePrice() {
        return insurancePrice;
    }

    public SaveRentalActivityResource setInsurancePrice(double insurancePrice) {
        this.insurancePrice = insurancePrice;
        return this;
    }
}
