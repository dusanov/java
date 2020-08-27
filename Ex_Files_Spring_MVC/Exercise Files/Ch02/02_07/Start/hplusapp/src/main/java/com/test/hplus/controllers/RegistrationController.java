package com.test.hplus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @PostMapping("/registeruser")
    public String registerUser(){
        System.out.println("in registration controller");
        return "login";
    }
}
