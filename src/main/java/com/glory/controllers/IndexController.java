package com.glory.controllers;

import com.glory.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Monster on 2017/11/18.
 */

@Controller
@RequestMapping("/Index")
public class IndexController {

    @RequestMapping(value = "/Index", method = RequestMethod.GET)
    public String login(HttpServletRequest request, HttpServletResponse response,HttpSession httpSession) throws ServletException, IOException {


        User user = (User) httpSession.getAttribute("User");
        if (user == null) {
//            response.sendRedirect("/Passport/Login");
            request.getRequestDispatcher("/Passport/Login").forward(request, response);
        }
        return "index/index";
    }
}
