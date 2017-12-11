package com.glory.controller;

import com.glory.entity.Group;
import com.glory.entity.ResponseJson;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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


    @RequestMapping(value = "/EditForm",method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson edit(@RequestParam("id") String id, @RequestParam("groupId") String groupId, @RequestParam("roleId") String roleId){
        ResponseJson responseJson;

        User user = new User(Integer.parseInt(id),Integer.parseInt(roleId),Integer.parseInt(groupId));

        if( userService.edit(user)!=0){

            responseJson = new ResponseJson(0, null, "成功");

        } else {
            responseJson = new ResponseJson(106, null, "编辑失败");
        }

        return responseJson;

    }

    @RequestMapping(value = "/DeleteForm",method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson delete(@RequestParam("id") String id){
        ResponseJson responseJson;

        if( userService.delete(Integer.parseInt(id))!=0){

            responseJson = new ResponseJson(0, null, "成功");

        } else {
            responseJson = new ResponseJson(105, null, "删除失败");
        }
        return responseJson;

    }

}
