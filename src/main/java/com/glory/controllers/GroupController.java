package com.glory.controllers;

import com.glory.entity.Group;
import com.glory.entity.ResponseJson;
import com.glory.service.GroupService;
import com.glory.service.impl.GroupServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.swing.*;
import java.util.List;

/**
 * Created by Monster on 2017/11/18.
 */

@Controller
@RequestMapping("Group")
public class GroupController {

    private GroupService groupService = new GroupServiceImpl();

    @RequestMapping(value = "List",method = RequestMethod.GET)
    public String list(HttpServletRequest request){
        List<Group> groups  =  groupService.getGroup();
        if (groups!=null){
            request.setAttribute("groups", groups);
        }
        return "group/list";
    }

    @RequestMapping(value = "Create",method = RequestMethod.GET)
    public String create(HttpServletRequest request){

        List<Group> groups  = groupService.getGroup();
        if (groups!=null){
            request.setAttribute("groups", groups);
        }
        return "group/create";
    }

    @RequestMapping(value = "/CreateGroupForm", method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseJson registerForm(@RequestParam("groupName") String groupName, @RequestParam("leaderId") String leaderId) {

        ResponseJson responseJson;

        Group  group = new Group();
        group.setGroup(groupName);
        group.setLeaderId(Integer.parseInt(leaderId));


        if (groupService.create(group) != 0) {

            responseJson = new ResponseJson(0, null, "成功");

        } else {
            responseJson = new ResponseJson(104, null, "添加分组失败");
        }

        return responseJson;
    }

}
