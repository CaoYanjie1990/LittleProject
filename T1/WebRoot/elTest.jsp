<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'elTest.jsp' starting page</title>
    
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
  	request.setAttribute("user", "你好request");
  	session.setAttribute("user", "你好session");
   %>
   <!-- el:依次访问:page request session application,当找到了或者找完了会停止 -->
   <!-- 如果不指定作用域,会依次访问:page request session application
   	   1:造成了效率底下,因为需要一个个去访问
   	   2:有可能有访问错误
    -->
    el:表达式${user}
   <hr>
   <!-- el:访问指定作用域中的变量 -->
    el:访问session${sessionScope.user}
  </body>
</html>
