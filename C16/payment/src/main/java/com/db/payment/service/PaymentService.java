package com.db.payment.service;


import com.db.payment.dao.PaymentDAO;
import com.db.payment.dao.PaymentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    PaymentDAO paymentDAO;


    public Boolean createCard(PaymentModel paymentModel) {
        return paymentDAO.saveCard(paymentModel);


    }

}
