package com.foreknow.elm.controller;

import com.foreknow.elm.po.User;
import com.foreknow.elm.service.UserService;
import com.foreknow.elm.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class UserController {

public Object getUserByIdByPass(HttpServletRequest request) throws Exception{
    String userId = request.getParameter("userId");
    String password = request.getParameter("password");
    UserService userService = new UserServiceImpl();
    User userByIdByPass = userService.getUserByIdByPass(userId, password);
    return userByIdByPass;
}
public Object getUserById(HttpServletRequest request)throws Exception{
    String userId = request.getParameter("userId");
    UserServiceImpl userService = new UserServiceImpl();
    int userById = userService.getUserById(userId);
    return  userById;
}

public Object saveUser(HttpServletRequest request)throws  Exception{
    String userId = request.getParameter("userId");
            String password = request.getParameter("password");
    String userName = request.getParameter("userName");
    Integer userSex = Integer.valueOf(request.getParameter("userSex"));
    UserServiceImpl userService = new UserServiceImpl();
    int i = userService.saveUser(userId, password, userName, userSex);
    return i;
}
}
