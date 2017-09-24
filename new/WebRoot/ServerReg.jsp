<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.lz.bin.UserInfo"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ServerReg.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
  </head>
  
  <body>
   <h1>用户注册中转界面</h1> <br>
    <%
    	String userName = request.getParameter("logName");
    	String psw = request.getParameter("logpsw");
    	
    	out.print(userName+":"+psw);
    
    		boolean flag = UserInfo.findUser(userName);
    		String msg = null;
    	if(flag){
    		msg =  "<script>alert('用户名已占用，请重新输入');</script>";
    		request.setAttribute("msg",msg);
    		request.getRequestDispatcher("Register.jsp").forward(request, response);
    	} else{
    		UserInfo.addinfo(userName,psw);
    		request.setAttribute("name", userName);
    		request.getRequestDispatcher("Login.jsp").forward(request, response);
    	}
     %>
  </body>
</html>
