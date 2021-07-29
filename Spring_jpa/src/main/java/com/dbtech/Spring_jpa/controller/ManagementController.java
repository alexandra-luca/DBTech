package com.dbtech.Spring_jpa.controller;

import com.dbtech.Spring_jpa.dto.LoginForm;
import com.dbtech.Spring_jpa.security.UserSession;
import com.dbtech.Spring_jpa.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ManagementController {

    @Autowired
    UserSession userSession;

    @Autowired
    CustomerService customerService;

    @GetMapping("/dashboard")
    public ModelAndView getDashboardPage() {
        int userId = userSession.getUserId();
        if (userId > 0) {
            return new ModelAndView("dashboard.html");
        } else {
            return new ModelAndView("redirect:/login");
        }
    }

    @GetMapping("/login")
    public ModelAndView getLoginPage() {
        return new ModelAndView("login.html");
    }

    @PostMapping
//    @Consumes
//    form url encoded
    public ModelAndView postLogin(@RequestBody LoginForm loginForm) {
        // validez ca exista un user -> select * from customer where email=... and password=...
//        customerService.getCustomerByEmailAndPassword
        // setam in session informatii despre user
        userSession.setUserId(id_utilizator);
        // daca exista redirect catre dashboard
        return new ModelAndView("redirect:/dashboard");
    }
}
