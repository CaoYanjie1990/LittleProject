<%@page import="com.zl.User"%>
<%@page import="com.zl.util.UserInfo"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'serverLogin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%
    	//接受用户名和密码
    	String logName = request.getParameter("logName");
    	String logPwd = request.getParameter("logPwd");
    	//校验
    	boolean isOk =  UserInfo.findUser(logName,logPwd);
    	
    	if(isOk==false){
    		//失败
    		String msg = "<script>alert('用户名或者密码有误!请检查');</script>";
    		request.setAttribute("msg", msg);
    		//请求转发
    		request.getRequestDispatcher("login.jsp").forward(request, response);
    	}else{
    		//session存储数据(用户信息)
    		//生命周期:浏览器不关闭,该session一直存在
    		User user = new User(logName,logPwd);
    		session.setAttribute("user", user);
    		//响应.重定向(不会影响session中的值)
    		response.sendRedirect("index.jsp");
    	}
     %>
  </body>
</html>
