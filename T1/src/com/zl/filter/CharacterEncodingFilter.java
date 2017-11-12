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
 * �������������filter
 */
public class CharacterEncodingFilter implements Filter{

	private String encoding = "";//�ַ����뼶��
	
	public void destroy() {
		System.out.println("CharacterEncodingFilter destroy");
	}
	/**
	 * ��������
	 */
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("CharacterEncodingFilter doFilter");
		//��ȡHttpServletRequest��HttpServletResponse
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		/**
		 * ��������
		 */
		request.setCharacterEncoding(encoding);//�����û����͵�����
		response.setCharacterEncoding(encoding);//�����������Ӧ������
		response.setHeader("Content-Type", "text/html;charset=UTF-8");//������Ӧͷ
		chain.doFilter(request, response);//���������������(��ԭ���ĵط�ȥ����)
	}
	/**
	 * ��ʼ��ʱͨ��FilterConfig������ж�ȡ
	 */
	public void init(FilterConfig fc) throws ServletException {
		encoding = fc.getInitParameter("encoding");
		System.out.println("��ȡ�����ַ�����:"+encoding);
		System.out.println("CharacterEncodingFilter init");
	}

}
