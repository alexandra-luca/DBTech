package com.dbtech.cryptoexchange.exchange;

import com.dbtech.cryptoexchange.customer.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExchangeService implements ExchangeServiceContract {
    @Autowired
    private JdbcTemplate template;

    @Override
    public List<Exchange> getAllExchanges() {
        List<Exchange> exchanges = template.query("SELECT * FROM exchange;", new ExchangeMapper());
        return exchanges;
    }
}
