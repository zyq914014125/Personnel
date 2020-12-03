<%--
  Created by IntelliJ IDEA.
  User: zyq914014125
  Date: 2020/12/3
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<%=path%>css/layui.css"  media="all">
</head>
<body>

<form  action="<%=path%>user?method=personalUpdate" method="post">
    <div class="layui-form-item">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-block">
            <input type="text" name="username" lay-verify="required" lay-reqtext="用户名是必填项，岂能为空？" placeholder="${user.username}" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-block">
            <input type="text" name="password" lay-verify="required" lay-reqtext="密码是必填项，岂能为空？" placeholder="${user.password}" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-inline">
                <input type="tel" name="name" lay-verify="required|phone" autocomplete="off" class="layui-input" placeholder="${user.name}">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">手机</label>
            <div class="layui-input-inline">
                <input type="tel" name="telephone" lay-verify="required|phone" autocomplete="off" class="layui-input" placeholder="${user.telephone}">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">住址</label>
            <div class="layui-input-inline">
                <input type="text" name="address" lay-verify="email" autocomplete="off" class="layui-input" placeholder="${user.address}">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">年龄</label>
            <div class="layui-input-inline">
                <input type="text" name="age" lay-verify="required|number" autocomplete="off" class="layui-input" placeholder="${user.age}">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">职位</label>
            <div class="layui-input-inline">
                <input type="text" name="age" lay-verify="required|number" autocomplete="off" class="layui-input" placeholder="${user.roleName}" disabled>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">单选框</label>
                <input type="hidden" value="${user.sex}" id="sexhidden">
                <input type="radio" name="sex" value="男"  style="margin-top: 10px;" id="man">男
                <input type="radio" name="sex" value="女" style="margin-top: 10px;margin-left: 20px" id="lady">女
        </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
    </div>
</form>

<script src="<%=path%>js/layui.js" charset="utf-8"></script>
<script src="<%=path%>js/jquery.js" charset="utf-8"></script>
<script>
    var sex=$("#sexhidden").val();
    if(sex !=null){
        if(sex =='男'){
            $("#man").click()
        }else
            $("#lady").click()
    }
    else
        $("#man").click()
</script>



</body>
</html>
