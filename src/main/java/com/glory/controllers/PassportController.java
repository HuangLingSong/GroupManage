package com.glory.controllers;

import com.glory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Monster on 2017/11/17.
 */

@Controller
@RequestMapping("/Passport")
public class PassportController {

    @RequestMapping(value = "/Login",method = RequestMethod.POST)
    public String login() {

        return "passport/login";
    }


    @RequestMapping(value = "/Register",method = RequestMethod.POST)
    public String register() {

        return "passport/register";
    }

    @RequestMapping("/Logout")
    public String logout() {

        return "passport/login";
    }

    @RequestMapping(value = "/Forgot",method = RequestMethod.POST)
    public String forgot() {

        return "passport/forgot";
    }

    @RequestMapping(value = "/GetUser",method = RequestMethod.POST)
    public String getUser(@RequestParam("email") String email) {

        return "passport/login";
    }

}
