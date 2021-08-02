package com.db.payment.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDAO {


    public Boolean saveCard(PaymentModel paymentModel);



}
