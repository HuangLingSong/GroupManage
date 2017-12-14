package com.glory.controller;


import com.glory.entity.Article;
import com.glory.entity.Chat;
import com.glory.entity.ResponseJson;
import com.glory.entity.User;
import com.glory.service.ChatService;
import com.glory.service.impl.ChatServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("Chat")
public class ChatController {

    @Autowired(required = true)
    private ChatService chatService = new ChatServiceImpl();

    @RequestMapping(value = "Chat",method = RequestMethod.GET)
    public String create(HttpServletRequest request){
        return "/chat/chat";
    }

    @RequestMapping(value = "getMessage",method = RequestMethod.POST)
    @ResponseBody
    public ResponseJson getMessage(@RequestParam("lastMsgTime") String lastMsgTime){
        List<Chat> chats = chatService.getNewMessage(lastMsgTime);
        ResponseJson responseJson;
        if (chats != null) {

            responseJson = new ResponseJson(0, chats, "成功");

        } else {
            responseJson = new ResponseJson(104, null, "失败");
        }
        return responseJson;
    }

    @RequestMapping(value = "Send",method = RequestMethod.POST)
    @ResponseBody
    public ResponseJson saveMessage(@RequestParam("message") String message,@RequestParam("user_id") int user_id){
        Chat chat = new Chat();
        chat.setContent(message);
//        chat.setUserId(user_id);
        chatService.savaMessage(chat);
        ResponseJson responseJson;


        responseJson = new ResponseJson(0, null, "成功");


        return responseJson;
    }

}
