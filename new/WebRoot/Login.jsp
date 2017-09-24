<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
   <h1>登录界面</h1><br>
   <%=request.getAttribute("msg") %>
   <%=request.getAttribute("name") %>
   <%
   		String status = String.valueOf(request.getAttribute("status"));
   		Cookie[] coArray = request.getCookies();
   		String username = "";
   		String userpwd = " ";
   		
   		if(coArray != null){
   			for(Cookie cookie : coArray){
   				if("username".equals(cookie.getName())){
   					username = cookie.getValue();
   				}else if("userpwd".equals(cookie.getName())){
   					userpwd = cookie.getValue();
   				}
   			}
   		}
   		
   		if(!status.equals("500")){
   			String url = "Server.jsp?userName="+username+"&password="+userpwd;
   			request.getRequestDispatcher(url).forward(request, response);
   		
   		}
   
    %>
   <form action="Server.jsp" method="post">
   	<label>用户名：<input name="userName" value="<%=username %>"></label><br>
   	<label>密码值：<input name="password" type="password" value="<%=userpwd %>"></label><br>
   	<button type="submit">登录</button>
   	
   </form>
   <button  onclick="Register.jsp">注册</button>
  </body>
</html>
