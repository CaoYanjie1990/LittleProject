<%@page import="com.zl.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
    		/**
    		 	如果没有登录则返回登录界面
    		*/
    		if(session.getAttribute("user")==null){
    			String msg = "<script>alert('请先登录');</script>";
    			request.setAttribute("msg", msg);
    			request.getRequestDispatcher("login.jsp").forward(request, response);
    		}else{
    			String userName = ((User)session.getAttribute("user")).getUserName();
    			out.print("欢迎您~~~~!"+userName);		
    		}
    	%>
  </body>
</html>
