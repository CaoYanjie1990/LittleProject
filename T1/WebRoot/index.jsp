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
  	
    <strong>gt:大于</strong>3 gt 2:${3 gt 2 }<br>
    <strong>lt:小于</strong>1 lt 2:${1 lt 2 }<br>
    <strong>eq:等于</strong>1 eq 2:${1 eq 2 }<br>
    <strong>ge:大于等于</strong>2 ge 2:${2 ge 2 }<br>
    <strong>le:小于等于</strong>1 le 2:${1 le 2 }<br>
   <!-- <strong>ne:不等于</strong>1 ne 2:${1 ne 2}<br> --> 
    <h3>检测是否为空</h3>
    <%
    	pageContext.setAttribute("test1", null);
    	pageContext.setAttribute("test2", 123);
     %>
     ${true and true}
     ${true or true}
    <strong>empty test1(test1=null)</strong>${empty test1}<br>
    <strong>empty test2(test2=123)</strong>${empty test2}
  </body>
</html>
