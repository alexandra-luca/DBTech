package com.db.payment;

import com.db.payment.dao.PaymentModel;
import com.db.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping("/payment")
    @ResponseBody
    public String getPayment(@RequestBody PaymentModel paymentModel)
    {
        return paymentService.createCard(paymentModel).toString();

    }

}
