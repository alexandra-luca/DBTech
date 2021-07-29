package com.dbtech.advanced1.controller;

import com.dbtech.advanced1.components.ProdBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Autowired
    ProdBean prodBean;

    @GetMapping("/bean")
    public String getBean() {
        return prodBean.toString();
    }
}
