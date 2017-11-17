package com.glory.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Monster on 2017/11/17.
 *
 * Test controller
 *
 */
@Controller
@RequestMapping("Hello")
public class HelloController {
    @RequestMapping(method = RequestMethod.GET)
    public String printHello(ModelMap model) {

        model.addAttribute("message", "Hello Spring MVC Framework!");
        System.out.print("message: Hello Spring MVC Framework!");
        return "hello";
    }
}
