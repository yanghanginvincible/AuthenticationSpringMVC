package com.hang.security.springmvc.controller;

import com.hang.security.springmvc.model.AuthenticationRequest;
import com.hang.security.springmvc.model.UserDto;
import com.hang.security.springmvc.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {

    @Autowired
    AuthenticationService authenticationService;

    @RequestMapping(value = "/login", produces = {"text/plain;charset=utf-8"})
    public String login(AuthenticationRequest authenticationRequest, HttpSession session){

        UserDto user = authenticationService.authentication(authenticationRequest);

        session.setAttribute(UserDto.SESSION_USER_KEY,user);
        return user.getFullname()+"denglu成功";
    }

    @RequestMapping(value = "/r/r2",produces = {"text/plain;charset=utf-8"})
    public String r1(HttpSession session){
        if(session.getAttribute(UserDto.SESSION_USER_KEY)==null){
            return "session 中无数据";
        }
        UserDto userDto = (UserDto)session.getAttribute(UserDto.SESSION_USER_KEY);
        return userDto.getFullname()+"已经存入session中";
    }

//    @RequestMapping(value = "logout")
//    public String r2(HttpSession session){
//        session.removeAttribute(UserDto.SESSION_USER_KEY);
//        return "/r1/r2";
//    }
}
