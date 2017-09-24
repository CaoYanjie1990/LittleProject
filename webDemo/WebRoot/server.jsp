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
    
    <title>My JSP 'server.jsp' starting page</title>
    
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
		<!-- 处理请求 -->
		<%
			String regName = request.getParameter("regName");
			//重构regName
			//regName = new String(regName.getBytes("iso-8859-1"),"UTF-8");
			String regPwd = request.getParameter("regPwd");
			/**
				业务逻辑
				判断该用户是否占用
			*/
			 boolean isOk = UserInfo.findUser(regName);
			 if(isOk){
			 		request.setAttribute("msg", "<script>alert('用户名被占用!')</script>");
			 		//用户名被占用,返回注册页面
			 		//方式一
			 		//response.sendRedirect("register.jsp");
			 		//方式二
			 		request.getRequestDispatcher("register.jsp").forward(request, response);
			 }else{
			 	//将用户名和密码放入到map中
			 	UserInfo.setMap(regName, regPwd);
			 	request.setAttribute("username", regName);
			 	//请求转发
			 	request.getRequestDispatcher("index.jsp").forward(request, response);
			 	
			 }
			 
		 %>
		 <%=regName%>-<%=regPwd%>
  </body>
</html>
