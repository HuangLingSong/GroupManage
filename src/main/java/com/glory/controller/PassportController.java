package com.glory.controller;

import com.glory.entity.Message;
import com.glory.entity.ResponseJson;
import com.glory.entity.User;
import com.glory.libraries.MD5Utils;
import com.glory.service.MessageService;
import com.glory.service.UserService;
import com.glory.service.impl.MessageServiceImpl;
import com.glory.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by Monster on 2017/11/17.
 */

@Controller
@RequestMapping("/Passport")
//@SessionAttributes(value = "User")
public class PassportController {

    private UserService userService = new UserServiceImpl();

    private MessageService messageService = new MessageServiceImpl();



    @RequestMapping(value = "/Login", method = RequestMethod.GET)
    public String login()  {
        return "passport/login";
    }

    @RequestMapping(value = "/Register", method = RequestMethod.GET)
    public String register() {
        return "passport/register";
    }

    @RequestMapping("/Logout")
    public String logout(HttpSession httpSession) {
        httpSession.removeAttribute("User");
        return "redirect:Login";
    }

    @RequestMapping(value = "/Forgot", method = RequestMethod.GET)
    public String forgot() {
        return "passport/forgot";
    }

    @RequestMapping(value = "/GetUser", method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson getUser(@RequestParam("email") String email) {

        ResponseJson responseJson;

        User user = userService.getUserByEmail(email);
        if (user != null) {
            responseJson = new ResponseJson(0, user.getUsername(), "用户存在");
        } else {
            responseJson = new ResponseJson(102, null, "用户不存在");
        }



        return responseJson;
    }

    @RequestMapping(value = "/LoginForm", method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson loginForm(@RequestParam("email") String email, @RequestParam("password") String passwd, HttpSession httpSession) {
        ResponseJson responseJson;
        passwd = MD5Utils.MD5(passwd);

        User user = userService.getUserByEmail(email);

        if (user != null) {

            if (passwd.equals(user.getPassword())) {
                responseJson = new ResponseJson(0, null, "登录成功");
                user.setPassword("");

                httpSession.setAttribute("User", user);
            } else {
                responseJson = new ResponseJson(103, null, "密码错误");
            }

        } else {
            responseJson = new ResponseJson(102, null, "用户不存在");
        }
        return responseJson;

    }

    @RequestMapping(value = "/RegisterForm", method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson registerForm(@RequestParam("email") String email, @RequestParam("password") String passwd, @RequestParam("name") String name) {

        ResponseJson responseJson;

        passwd = MD5Utils.MD5(passwd);

        User user = new User(name, email, passwd);


        if (userService.register(user) != 0) {

            responseJson = new ResponseJson(0, null, "注册成功");

        } else {
            responseJson = new ResponseJson(104, null, "注册失败");
        }

        return responseJson;
    }

    @RequestMapping(value = "/ForgotForm", method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson forgotForm(@RequestParam("email") String email) {

        ResponseJson responseJson;

        Message message = new Message();

        message.setContent(email);
        if (messageService.forgotPasswd(message) != 0) {

            responseJson = new ResponseJson(0, null, "添加成功");

        } else {
            responseJson = new ResponseJson(104, null, "添加消息失败");
        }
        return responseJson;
    }
}
