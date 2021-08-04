package shopifyadvanced.controller;

import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.servlet.ModelAndView;
import shopifyadvanced.dao.model.Customer;
import shopifyadvanced.dto.LoginForm;
import shopifyadvanced.service.CustomerService;

import java.util.Base64;

@Controller
public class LoginController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/basic-auth")
    public ModelAndView basic_auth(@RequestBody LoginForm loginForm)
    {
        ModelAndView view = new ModelAndView("simpleResponse.html");
        Customer c = customerService.findCustomerByUsernameAndPassword(loginForm.getUsername(), loginForm.getPassword());
        if (c!= null)
        {
            String myString = loginForm.getUsername() + "," + loginForm.getPassword();
            Base64.Encoder encoder = Base64.getEncoder();
            String encoded_string = encoder.encodeToString(myString.getBytes());
            view.addObject("variabila",encoded_string);
            return view;
        }
        return null;
    }


//    @GetMapping("/login")
//    public ModelAndView getAllCustomersHtml() {
//        ModelAndView view = new ModelAndView("login.html");
//
//
//
//        return view;
//    }


}
