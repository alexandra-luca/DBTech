package com.dbtech.advanced1.components;

import lombok.extern.java.Log;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Profile("prod")
@Log
public class ProdBean {

    public ProdBean() {
        System.out.println("ProdBean constructor");
    }

    @PostConstruct
    void pc() {
        log.info("ProdBean");
    }

}