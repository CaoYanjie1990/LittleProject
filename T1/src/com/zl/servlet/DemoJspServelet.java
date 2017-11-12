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
		out.print("server not connect ...... ����ʧ��");
		out.print("<strong>superman-doGet</strong>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset="+init_encoding);
		PrintWriter out = response.getWriter();
		out.print("server not connect ...... ����ʧ��");
		out.print("<strong>superman-doPost</strong>");
	}
	
	//��ʼ����ʵ��ʱ���õķ���
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.err.println("DemoJspServelet��ʼ��ʼ��...");
		System.err.println("�������ݿ����ӡ���������");
		System.err.println("����ģ������......");
		System.err.println("�������ݿ�����-�ɹ�");
		System.err.println("����ģ������-�ɹ�");
		//��ȡweb.xml�����õĳ�ʼ������
		String value = config.getInitParameter("characterEncoding");
		init_encoding = value;
		System.out.println("DemoJspServelet-Ĭ���ַ����뼶��Ϊ:"+value);
	}
	//�ݻٸ�ʵ��ʱ���õķ���
	@Override
	public void destroy() {
		System.err.println("�ر����ݿ����ӡ���������");
		System.err.println("���ģ������......");
		System.err.println("�ر����ݿ�����-�ɹ�");
		System.err.println("���ģ������-�ɹ�");
	}
}
