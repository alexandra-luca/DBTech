package com.dbtech.advanced1.components;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Log
public class MyConfiguration {
//    public  MyConfiguration(@Value("${my.msg}") String msg) {
//        log.info(msg);
//    }

    @Bean
    @Profile("prod")
    ProdBean getMyBean() {
        return new ProdBean();
    }
}
