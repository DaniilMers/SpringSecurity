package net.spring.springsecuritydemo.config.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class AuthController {

    @GetMapping("/login")
    public String GetLoginPage() {
        return "login";
    }


    @GetMapping("/success")
    public String GetSuccessPage() {
        return "success";
    }
}
