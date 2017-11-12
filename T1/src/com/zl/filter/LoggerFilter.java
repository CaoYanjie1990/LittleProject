package com.zl.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.zl.util.Logger;

public class LoggerFilter implements javax.servlet.Filter {

	private Logger logger = new Logger();
	
	public void destroy() {
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		
		/**
		 * 日志操作
		 */
		logger.info("IP:"+request.getRemoteAddr()+"_访问:"+request.getMethod()+"_地址:"+request.getRequestURI());
		
		arg2.doFilter(arg0, arg1);
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
