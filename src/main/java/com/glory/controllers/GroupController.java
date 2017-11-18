package com.glory.controllers;

import com.glory.entity.Group;
import com.glory.service.GroupService;
import com.glory.service.impl.GroupServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
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

}
