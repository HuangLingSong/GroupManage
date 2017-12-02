package com.glory.controllers;

import com.glory.model.Group;
import com.glory.model.ResponseJson;
import com.glory.model.User;
import com.glory.service.GroupService;
import com.glory.service.UserService;
import com.glory.service.impl.GroupServiceImpl;
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
@RequestMapping("Group")
public class GroupController {

    private GroupService groupService = new GroupServiceImpl();

    private UserService userService = new UserServiceImpl();

    @RequestMapping(value = "List",method = RequestMethod.GET)
    public String list(HttpServletRequest request){
        List<Group> groups  =  groupService.getGroup();
        if (groups!=null){
            request.setAttribute("groups", groups);
        }
        return "group/list";
    }


      /*
       *
       * parameter :HttpServletRequest request,String id
       *
      */
    @RequestMapping(value = "Handler",method = RequestMethod.GET)
    public String create(HttpServletRequest request,@RequestParam("id") String id){

        //获取所有组信息
        List<Group> groups  = groupService.getGroup();
        if (groups!=null){
            //返回所有组给view
            request.setAttribute("groups", groups);
        }

        //获取所有用户信息
        List<User> users =  userService.getUser();
        if (users!=null){
            //返回所有用用户给view
            request.setAttribute("users", users);
        }
//        编辑分组是返回要编辑小组id 用select标签默认选中
        request.setAttribute("filter", Integer.parseInt(id));
        return "group/handler";
    }

    @RequestMapping(value = "MyGroup",method = RequestMethod.GET)
    public String myGroup(HttpServletRequest request,@RequestParam("gid") String gid){

        List<User> myGroup  = groupService.getMyGroup(Integer.parseInt(gid));
        if (myGroup!=null){
            request.setAttribute("myGroup", myGroup);
        }
        return "group/mygroup";
    }

    @RequestMapping(value = "JoinGroup",method = RequestMethod.GET)
    public String joinGroup(HttpServletRequest request){
        List<Group> groups  =  groupService.getGroup();
        if (groups!=null){
            request.setAttribute("groups", groups);
        }
        return "group/joingroup";
    }


    @RequestMapping(value = "DeleteGroupForm",method = RequestMethod.POST)
    public @ResponseBody ResponseJson delete(@RequestParam("id") String id){

        ResponseJson responseJson;

       if( groupService.delete(Integer.parseInt(id))!=0){
           responseJson = new ResponseJson(0, null, "成功");
       }else {
           responseJson = new ResponseJson(105, null, "删除分组失败");
       }
//        return "redirect:List";
        return responseJson;
    }

    @RequestMapping(value = "CreateGroupForm", method = RequestMethod.POST)
    public @ResponseBody ResponseJson CreateGroupForm(@RequestParam("groupName") String groupName, @RequestParam("leaderId") String leaderId) {

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

    @RequestMapping(value = "EditGroupForm", method = RequestMethod.POST)
    public @ResponseBody ResponseJson EditGroupForm(@RequestParam("groupName") String groupName, @RequestParam("leaderId") String leaderId,@RequestParam("grouptId") String grouptId) {
        ResponseJson responseJson;

        Group  group = new Group();
        group.setId(Integer.parseInt(grouptId));
        group.setGroup(groupName);
        group.setLeaderId(Integer.parseInt(leaderId));


        if (groupService.edit(group) != 0) {

            responseJson = new ResponseJson(0, null, "成功");

        } else {
            responseJson = new ResponseJson(104, null, "编辑分组失败");
        }

        return responseJson;
    }

}
