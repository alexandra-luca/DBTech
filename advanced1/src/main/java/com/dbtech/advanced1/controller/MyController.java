package com.dbtech.advanced1.controller;

import com.dbtech.advanced1.components.ProdBean;
import com.dbtech.advanced1.controller.messages.MessagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Member;
import java.security.MessageDigest;

@RestController
public class MyController {
//    @Autowired
//    ProdBean prodBean;

    @Qualifier("orice")
    @Autowired
    MessagingService messagingService;

//    @GetMapping("/bean")
//    public String getBean() {
//        return prodBean.toString();
//    }

    @GetMapping("/message")
    public String getMessage() {
        return messagingService.getMessage();
    }
}
