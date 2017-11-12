<%@page import="com.zl.bean.User"%>
<%@page import="com.zl.dao.UserDao"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>无标题文档</title>
	<link type="text/css" rel="stylesheet" href="css/common.css" />
	<style type="text/css">
<!--
-->
</style>
</head>
<script>
	function del(name, id) {
		if (confirm("是否删除用户" + name + "?")){
			alert("删除成功!");
		}
	}
</script>
<body>
	<!--页面顶部-->
	<div id="header">
		<div class="main-top">
			<div class="logo">
				<a href=""><span>新闻大视野</span> </a>
			</div>

			<div class="nav">
				<ul class="clearfix">
					<li><a href="#">首页</a></li>
					<li><a href="#">国内</a></li>
					<li><a href="#">国际</a></li>
					<li><a href="#">娱乐</a></li>
					<li><a href="#">军事</a></li>
				</ul>
			</div>
		</div>
		<!--banner-->
		<div class="main-banner">
			<img src="images/banner.png" />
		</div>
		<!--管理工具栏-->
		<div class="admin-bar">
			<span class="fr">退出账户</span> 管理员：admin 2012-06-19
		</div>
	</div>
	<!--主体-->
	<div id="content" class="main-content clearfix">
		<div class="main-content-left">
			<!--新闻管理-->
			<div class="class-box">
				<div class="class-box-header">
					<h3>新闻管理</h3>
				</div>
				<div class="class-box-content">
					<ul>
						<li><a href="#">新闻管理</a>
						</li>
						<li class="clear-bottom-line"><a href="#">最新新闻</a>
						</li>
					</ul>
				</div>
			</div>
			<!--//-->
			<!--主题管理-->
			<div class="class-box">
				<div class="class-box-header">
					<h3>分类管理</h3>
				</div>
				<div class="class-box-content">
					<ul>
						<li><a href="#">分类管理</a>
						</li>
						<li class="clear-bottom-line"><a href="#">删除主题</a>
						</li>
					</ul>
				</div>
			</div>
			<!--//-->
			<!--账户管理-->
			<div class="class-box">
				<div class="class-box-header">
					<h3>用户管理</h3>
				</div>
				<div class="class-box-content">
					<ul>
						<li><a href="#">用户管理</a>
						</li>
						<li class="clear-bottom-line"><a href="#">付费服务</a>
						</li>
					</ul>
				</div>
			</div>
			<!--//-->
		</div>
		<div class="main-content-right">
			<!--即时新闻-->
			<div class="main-text-box">
				<div class="main-text-box-tbg">
					<div class="main-text-box-bbg">
						<form name="searchForm" id="searchForm"
							action="/news/jsp/admin/newsDetailList.jsp" method="post">
							<div>
								新闻分类： <select name="categoryId">
									<option value="0">全部</option>

									<option value='1'>国内</option>

									<option value='2'>国际</option>

									<option value='3'>娱乐</option>

									<option value='4'>军事</option>

									<option value='5'>财经</option>

									<option value='6'>天气</option>

								</select> 新闻标题<input type="text" name="title" id="title" value='' />
								<button type="submit" class="page-btn">GO</button>
								<button type="button" onclick="addNews();" class="page-btn">增加</button>
								<input type="hidden" name="currentPageNo" value="1" /> <input
									type="hidden" name="pageSize" value="10" /> <input
									type="hidden" name="totalPageCount" value="2" />
							</div>
						</form>
						<a href="user/addUser.jsp">添加用户</a>
						<a href="loginout">登出</a>
						<table cellpadding="1" cellspacing="1" class="admin-list">
							<thead>
								<tr class="admin-list-head">
									<th>用户id</th>
									<th>用户名</th>
									<th>出生日期</th>
									<th>地址</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${page.list}" var="item" varStatus = "sta">
									<tr <c:if test="${sta.count%2 ne 0}">style="background-color: gray;"</c:if>>
										<td><a href='adminNewsView.jsp?id=2'></a><c:out value="${item.id}"></c:out></td>
										<td><a href="findUser?id=${item.id}"><img src="${item.userPic}" width="20px" height="20px"/>${item.username}</a></td>
										<td>${item.birthday}</td>
										<td>${item.address}</td>
										<td>
											<button onclick="del('${item.username}',${item.id})">删除</button>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<div class="page-bar">
							<ul class="page-num-ul clearfix">
								<c:if test="${page.current ne 1}">
									<a href="javascript:location.href='newsDetail2?page=1'">第一页</a>
								<a href="javascript:location.href='newsDetail2?page=${page.current-1}'">上一页</a>&nbsp;&nbsp;
								</c:if>
								<li>共5条记录&nbsp;&nbsp; ${page.current }/${page.total }页</li>
								<c:if test="${page.current ne page.total}">
									<a href="javascript:location.href='newsDetail2?page=${page.current+1}'">下一页</a>
								<a href="javascript:location.href='newsDetail2?page=${page.total}'">最后一页</a>&nbsp;&nbsp;
								</c:if>
							</ul>
							<span class="page-go-form"><label>跳转至</label> 
							<!-- 使用隐藏域保存值 -->
							<input type="hidden" id="pageTotal" value="${page.total}"/>
							<input type="text" name="inputPage" id="inputPage" class="page-key" />页
							<script>
								function jump(){
									//获取用户输入的页号
									var page = document.getElementById("inputPage").value;
									//判断用户输入的页号是否为 正确区间
									var pagetotal = document.getElementById("pageTotal").value;//获取总页数
									if(page<=pagetotal&&page>0){
										//发送 
										location.href="newsDetail2?page="+page;	
									}else{
										alert("请输入正确的区间,范围:1-"+pagetotal);
									}
									
								}
							</script>
							<button type="button" class="page-btn"
									onclick="jump()}">GO</button>
							</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--底部-->
	<div class="main-footer-box">
		24小时客户服务热线：010-68988888 常见问题解答 新闻热线：010-627488888<br />
		文明办网文明上网举报电话：010-627488888 举报邮箱：jubao@bj-aptech.com.cn<br />
		Coyright&copy;1999-2007 News China gov,All Right Reserved.<br />
		新闻中心版权所有
	</div>
</body>
</html>