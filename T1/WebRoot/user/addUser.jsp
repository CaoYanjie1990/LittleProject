<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addUser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="ckeditor/ckeditor.js"> </script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<%-- ${msg==null?"":msg} --%>
    <form action="addUser" method="post" enctype="multipart/form-data">
    	<label>用户名:<input name="username"><br></label>
    	<label>密码:<input name="password"><br></label>
    	<label>住址:<input name="address"><br></label>
    	<label>出生日期:<input name="birthday" type="date"><br></label>
    	<label>性别:<input name="gender" value="0" type="radio" checked>男 <input name="gender" value="1" type="radio">女</label>
    	<label>头像:<input name="userPic" type="file"></label>
    	<label>详细信息:<textarea name="detail" class="ckeditor" id="ckeditor"></textarea></label>
    	<button type="submit">添加</button>
    </form>
  </body>
</html>
