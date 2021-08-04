package com.db.payment.impl;

import com.db.payment.dao.PaymentDAO;
import com.db.payment.dao.PaymentModel;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentDAOImpl implements PaymentDAO {


    @Override
    public Boolean saveCard(PaymentModel paymentModel) {

        System.out.println("Am primit: "+paymentModel.toString());
        return true;
    }
}
