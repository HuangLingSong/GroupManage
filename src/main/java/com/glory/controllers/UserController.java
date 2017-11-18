package com.glory.controllers;

import com.glory.entity.Group;
import com.glory.entity.Role;
import com.glory.entity.User;
import com.glory.service.GroupService;
import com.glory.service.RoleService;
import com.glory.service.UserService;
import com.glory.service.impl.GroupServiceImpl;
import com.glory.service.impl.RoleServiceImpl;
import com.glory.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Monster on 2017/11/18.
 */
@Controller
@RequestMapping("User")
public class UserController {

    private UserService userService = new UserServiceImpl();

    private RoleService roleService = new RoleServiceImpl();

    private GroupService groupService = new GroupServiceImpl();

    @RequestMapping(value = "/List", method = RequestMethod.GET)
    public String list(HttpServletRequest request) {

        List<User> users =  userService.getUser();
        if (users!=null){
            request.setAttribute("users", users);
        }

        List<Group> groups  =  groupService.getGroup();
        if (groups!=null){
            request.setAttribute("groups", groups);
        }

        List<Role> roles  =  roleService.getrole();
        if (roles!=null){
            request.setAttribute("roles", roles);
        }

        return "user/list";
    }


    @RequestMapping(value = "/Group", method = RequestMethod.GET)
    public String group() {
        return "group/list";
    }
}
