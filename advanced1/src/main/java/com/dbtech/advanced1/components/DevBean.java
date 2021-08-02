package com.dbtech.advanced1.components;

import lombok.extern.java.Log;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Profile("dev")
@Log
public class DevBean {

    @PostConstruct
    void pc() {
        log.info("DevBean");
    }

}
