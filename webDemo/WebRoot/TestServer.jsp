<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'TestServer.jsp' starting page</title>
    
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
    			转发只可以服务器内部转发
    			重定向相当于客户端发送了一次新的请求.所有可以访问任何页面
    		*/
    		String type =  request.getParameter("type");
    		if("转发".equals(type)){
    			request.getRequestDispatcher("https://www.baidu.com/").forward(request, response);
    		}else{
    			response.sendRedirect("https://www.baidu.com/");
    		}
    	 %>
  </body>
</html>
