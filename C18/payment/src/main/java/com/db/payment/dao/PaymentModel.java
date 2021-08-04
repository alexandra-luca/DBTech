package com.db.payment.dao;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentModel {

    public String cardName;
    public String cardNumber;
    public int securityCode;


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PaymentModel{");
        sb.append("cardName='").append(cardName).append('\'');
        sb.append(", cardNumber='").append(cardNumber).append('\'');
        sb.append(", securityCode=").append(securityCode);
        sb.append('}');
        return sb.toString();
    }
}
