<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'register.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
  		<%=request.getAttribute("msg")%>
    	<h1>注册</h1>
    	<!-- 
    		get:url可以包含参数.
    		post:url不可以包含参数.大文件,注册,登录
    	 -->
    	<form action="server.jsp" method="get">
    		<label>用户名:<input name="regName"></label><br>
    		<label>密码:<input name="regPwd" type="password"></label><br>
    		<button type="submit">注册</button>
    	</form>
  </body>
</html>
