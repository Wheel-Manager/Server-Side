package com.example.wheelmanager.resource;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SaveCreditCardResource {
    @NotNull
    @Size(max = 100)
    private String cardNumber;

    @NotNull
    @Size(max = 100)
    private String cardCvv;

    public String getCardNumber() {
        return cardNumber;
    }

    public SaveCreditCardResource setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public String getCardCvv() {
        return cardCvv;
    }

    public SaveCreditCardResource setCardCvv(String cardCvv) {
        this.cardCvv = cardCvv;
        return this;
    }
}
