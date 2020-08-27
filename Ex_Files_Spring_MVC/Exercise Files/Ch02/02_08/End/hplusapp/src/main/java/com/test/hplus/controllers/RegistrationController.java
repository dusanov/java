package com.test.hplus.controllers;

import com.test.hplus.beans.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @PostMapping("/registeruser")
    public String registerUser(@ModelAttribute("newuser")User user){
        System.out.println("in registration controller");
        return "login";
    }
}
