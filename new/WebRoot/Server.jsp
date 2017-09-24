<%@page import="com.lz.bin.User"%>
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
    
    <title>My JSP 'Server.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">


  </head>
  
  <body>
    <h1>server</h1><br>
    <%
    	String userName = request.getParameter("userName");
    	String psw = request.getParameter("password");
    	
    	out.print(userName+":"+psw);
    	
    	Cookie co_user = new Cookie("user",userName);
    	Cookie co_psw = new Cookie("psw",psw);
    	
    	boolean isOK = UserInfo.findUser(userName,psw);
    	String msg = null;
    	if(isOK){
    		//request.setAttribute("msg", "<script>alert('用户名及密码正确，登录成功！');</script>");
    		User user = new User(userName,psw);
    		session.setAttribute("用户名", userName);
    		Integer num = Integer.valueOf(application.getAttribute("num") == null ?"0":application.getAttribute("num").toString());
    		num++;
    		application.setAttribute("num", num);
    		/**
    			保存用户信息到cookie
    			cookie保存到response中
    		*/
    		Cookie co_logname = new Cookie("username",userName);
    		Cookie co_logpsw = new Cookie("psw",psw);
    		co_logname.setMaxAge(3600);
    		co_logpsw.setMaxAge(3600);
    		response.addCookie(co_logname);
    		response.addCookie(co_logpsw);
    	    response.sendRedirect("index.jsp");
    		//response.sendRedirect("index.jsp");
    	}else{
    		request.setAttribute("msg", "<script>alert('用户名及密码不正确，请重新登录！');</script>");
    		request.setAttribute("status", 500);
    		request.getRequestDispatcher("Login.jsp").forward(request, response);
    	}
    	
     %>
  </body>
</html>
