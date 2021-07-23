package com.dbtech.cryptoexchange.exchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exchange")
public class ExchangeController {
    @Autowired
    private ExchangeServiceContract exchangeService;

    @GetMapping()
    public List<Exchange> getAllExchanges() {
        return exchangeService.getAllExchanges();
    }
}
