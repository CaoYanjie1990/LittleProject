<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'jstlDemo.jsp' starting page</title>
    
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
  			pageContext.setAttribute("test", "page作用域-使用c:out输出");
  			pageContext.setAttribute("testHtml", "page作用域-使用c:out输出<strong>12121</strong>");
  		 %>
    	<c:out value="${pageScope.test}" default="暂无数据"></c:out><br>
    	<c:out value="${pageScope.test1}" default="暂无数据"></c:out><br>
    	<c:out value="${pageScope.testHtml}" default="暂无数据" escapeXml="true"></c:out><br>
    	<!-- 
    		escapeXml="false";关闭转义:将文本中的标签输出为html而不是文本
    	 -->
    	<c:out value="${pageScope.testHtml}" default="暂无数据" escapeXml="false" ></c:out>
    	<!-- format -->
    	<%
    		pageContext.setAttribute("date", new Date());
    		pageContext.setAttribute("num", 123456789.123456);
    	 %>
    	 <fmt:formatDate value="${date}" pattern="yyyy-MM-dd hh:mm:ss"/>
    	 <fmt:formatNumber value="${num}" pattern="###,###.###"></fmt:formatNumber>
  </body>
</html>
