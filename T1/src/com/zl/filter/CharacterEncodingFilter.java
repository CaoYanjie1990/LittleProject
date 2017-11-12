package com.zl.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 处理中文乱码的filter
 */
public class CharacterEncodingFilter implements Filter{

	private String encoding = "";//字符编码级别
	
	public void destroy() {
		System.out.println("CharacterEncodingFilter destroy");
	}
	/**
	 * 处理请求
	 */
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("CharacterEncodingFilter doFilter");
		//获取HttpServletRequest和HttpServletResponse
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		/**
		 * 处理乱码
		 */
		request.setCharacterEncoding(encoding);//处理用户发送的数据
		response.setCharacterEncoding(encoding);//处理服务器响应的数据
		response.setHeader("Content-Type", "text/html;charset=UTF-8");//设置相应头
		chain.doFilter(request, response);//让请求接着向下走(向原来的地方去发送)
	}
	/**
	 * 初始化时通过FilterConfig对象进行读取
	 */
	public void init(FilterConfig fc) throws ServletException {
		encoding = fc.getInitParameter("encoding");
		System.out.println("获取到了字符编码:"+encoding);
		System.out.println("CharacterEncodingFilter init");
	}

}
