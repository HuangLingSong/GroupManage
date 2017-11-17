package com.glory.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Monster on 2017/11/17.
 */

@Controller
@RequestMapping("/Passport")
public class PassportController {

    @RequestMapping("/Login")
    public String login() {

        return "passport/login";
    }


    @RequestMapping("/Register")
    public String register() {

        return "passport/register";
    }

    @RequestMapping("/Logout")
    public String logout() {

        return "passport/login";
    }
    @RequestMapping("/Forgot")
    public String forgot() {

        return "passport/forgot";
    }

}
