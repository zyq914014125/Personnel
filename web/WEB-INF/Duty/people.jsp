<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>

</head>
<body>

		<div class="panel admin-panel">
			<div class="panel-head">
				<strong class="icon-reorder">人员管理</strong>
			</div>
			<div class="padding border-bottom">
				<ul class="search">
					<form action="<%=path%>user?method=peoplefind" method="post">
					<li>
						<input type="text" name="name" value="" placeholder="请输入姓名进行搜索">
							<input type="submit" style="width: 50px;height: 25px" value="搜索"></input>
					</li>
					</form>
				</ul>
			</div>

			<table class="table table-hover text-center">
				<tr>
					<th>员工姓名</th>
					<th>电话</th>
					<th>住址</th>
					<th>性别</th>
					<th>年龄</th>
					<th>职位</th>
					<th colspan="2">操作</th>
				</tr>
				<c:forEach items="${userList}" var="user">
					<form action="<%=path%>user?method=update" method="post">
						<input type="hidden" value="${user.user_id}" name="id">
					<tr>
						<td><input type="text" name="name" value="${user.name }" style="border: none;text-align: center"></td>
						<td><input type="text" name="telephone" value="${user.telephone}" style="border: none;text-align: center"></td>
						<td><input type="text" name="address" value="${user.address }" style="border: none;text-align: center"></td>
						<td><input type="text" name="sex" value="${user.sex }" style="border: none;text-align: center"></td>
						<td><input type="text" name="age" value="${user.age }" style="border: none;text-align: center"></td>
						<td><input type="text" name="roleName" value="${user.roleName }" style="border: none;text-align: center"></td>
						<td><input type="submit" value="修改" style="color: blue"></td>
						<td><a href="<%=path%>user?method=delete&user_id=${user.user_id}" style="color: red">删除</a></td>
					</tr>
					</form>
				</c:forEach>
			</table>

		</div>


</body>
</html>