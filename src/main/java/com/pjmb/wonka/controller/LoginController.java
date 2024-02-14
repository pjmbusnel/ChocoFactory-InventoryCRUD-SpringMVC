package com.pjmb.wonka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showLoginPage")
    public String showLoginPage() {
        return "custom-login";
    }

    @GetMapping("/accessDenied")
    public String showAccessDenied() {
        return "access-denied";
    }

}










