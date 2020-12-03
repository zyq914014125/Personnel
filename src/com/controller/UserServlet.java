package com.controller;

import com.entity.Duty;
import com.entity.User;
import com.service.DutyService;
import com.service.UserService;
import com.util.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/user")
public class UserServlet extends BaseServlet {

    UserService userService=new UserService();
    DutyService dutyService =new DutyService();
    public String login(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //用户查询
        User user=userService.queryUser(username);
        if(password.equals(user.getPassword())){
            System.out.println("恭喜，" + user.getName() + "登录成功，即将跳转...");
            //添加session
            HttpSession session = request.getSession();
            //权限查询
            List<Duty> roleList= dutyService.queryRole(user.getRole());
            session.setAttribute("user", user);
            //返回权限列表
            request.setAttribute("DutyList",roleList);
            request.setAttribute("username",user.getName());
            return "WEB-INF/user/studentIndex.jsp";
        }
        else {
            System.out.println("登陆失败，请检查用户名或密码是否正确");
            request.setAttribute("login_msg", "登陆失败，请检查用户名或密码是否正确");
            return "login.jsp";
        }
    }
    public String peoplefind(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
        //获取人员名字
        String name=request.getParameter("name");
        //调用查询业务
        List<User> userList=userService.queryByName(name);
        request.setAttribute("userList",userList);
        return "WEB-INF/Duty/people.jsp";
    }
    //人员操作
    public String update(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
        //获取人员id
            //获取修改内容
            User user=new User();
            user.setUser_id(Integer.parseInt(request.getParameter("id")));
            user.setName(request.getParameter("name"));
            user.setTelephone(request.getParameter("telephone"));
            user.setAddress(request.getParameter("address"));
            user.setSex(request.getParameter("sex"));
            user.setAge(request.getParameter("age"));
            userService.update(user);
            //全查询
            User user1=(User) request.getSession().getAttribute("user");
            List<User> usersList=userService.queryByRole(user1.getRole());
            request.setAttribute("userList",usersList);
            return "WEB-INF/Duty/people.jsp";
    }
    public String delete(HttpServletRequest request,HttpServletResponse response){
        //得到Id
        String id=request.getParameter("user_id");
        userService.delete(id);
        //全查询
        User user1=(User) request.getSession().getAttribute("user");
        List<User> usersList=userService.queryByRole(user1.getRole());
        request.setAttribute("userList",usersList);
        return "WEB-INF/Duty/people.jsp";
    }
    public String personalUpdate(HttpServletRequest request,HttpServletResponse response){
        //获取用户传入的参数
        User user=new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setName(request.getParameter("name"));
        user.setAge(request.getParameter("age"));
        user.setSex(request.getParameter("sex"));
        user.setTelephone(request.getParameter("telphone"));
        user.setAddress(request.getParameter("address"));
        userService.updateAll(user);
        //检测是否修改了密码和用户名，是则重新登录
        User userOld=(User) request.getSession().getAttribute("user");
        if(userOld.getPassword().equals(user.getPassword())&&userOld.getUsername().equals(user.getUsername())){
            request.setAttribute("user",user);
            return "WEB-INF/Duty/personal.jsp";
        }else
            //session注销
            request.getSession().invalidate();
            return "login.jsp";
    }
    public String register(HttpServletRequest request,HttpServletResponse response){
        User user=new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setName(request.getParameter("name"));
        user.setAge(request.getParameter("age"));
        user.setSex(request.getParameter("sex"));
        user.setTelephone(request.getParameter("telephone"));
        user.setAddress(request.getParameter("address"));
        user.setRole(Integer.parseInt(request.getParameter("role")));
        user.setRoleName(request.getParameter("roleName"));
        userService.Insert(user);
        return "login.jsp";
    }
}
