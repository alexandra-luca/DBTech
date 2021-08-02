package shopifyadvanced.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

public class LoginController {


    @GetMapping("/login")
    public ModelAndView getAllCustomersHtml() {
        ModelAndView view = new ModelAndView("login.html");



        return view;
    }


}
