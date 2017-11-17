package com.glory.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Monster on 2017/11/17.
 */

@Controller
@RequestMapping("/Passport")
public class PassportController {

    @RequestMapping("/login")
    public String login() {

        return "passport/login";
    }


    @RequestMapping("/register")
    public String register() {

        return "passport/register";
    }
}
