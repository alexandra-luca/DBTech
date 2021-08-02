package com.dbtech.advanced1.components;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@NoArgsConstructor
@Log
@Scope("singleton")
public class MyBean {
    @Getter @Setter
    private String name;

    @PostConstruct
    void postConstructMethod() {
        log.info("This is post construct for MyBean");
    }

    @PreDestroy
    void preDestroyMethod() {
        log.info("This is pre-destroy for MyBean");
    }

}
