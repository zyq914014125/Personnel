package com.controller;

import com.entity.User;
import com.service.UserService;
import com.util.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/duty")
public class DutyServlet extends BaseServlet {
UserService userService=new UserService();
    //人员管理
    public String people(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse){
        //这里老板可以查所有员工，经理只能查员工
        User user=(User) httpServletRequest.getSession().getAttribute("user");
        List<User> usersList=userService.queryByRole(user.getRole());
        httpServletRequest.setAttribute("userList",usersList);
        return "WEB-INF/Duty/people.jsp";
    }
    //信息修改
    public String information(HttpServletRequest request,HttpServletResponse httpServletResponse){
        //获取session
        User user=(User) request.getSession().getAttribute("user");
        //信息返回
        request.setAttribute("user",user);
        return "WEB-INF/Duty/personal.jsp";

    }

}
