package com.zl.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoJspServelet extends HttpServlet {
	private static String init_encoding = "ISO-8859-1";
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset="+init_encoding);
		PrintWriter out = response.getWriter();
		out.print("server not connect ...... 连接失败");
		out.print("<strong>superman-doGet</strong>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset="+init_encoding);
		PrintWriter out = response.getWriter();
		out.print("server not connect ...... 连接失败");
		out.print("<strong>superman-doPost</strong>");
	}
	
	//初始化该实例时调用的方法
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.err.println("DemoJspServelet开始初始化...");
		System.err.println("加载数据库连接。。。。。");
		System.err.println("加载模版数据......");
		System.err.println("加载数据库连接-成功");
		System.err.println("加载模版数据-成功");
		//读取web.xml中配置的初始化参数
		String value = config.getInitParameter("characterEncoding");
		init_encoding = value;
		System.out.println("DemoJspServelet-默认字符编码级别为:"+value);
	}
	//摧毁该实例时调用的方法
	@Override
	public void destroy() {
		System.err.println("关闭数据库连接。。。。。");
		System.err.println("清除模版数据......");
		System.err.println("关闭数据库连接-成功");
		System.err.println("清除模版数据-成功");
	}
}
