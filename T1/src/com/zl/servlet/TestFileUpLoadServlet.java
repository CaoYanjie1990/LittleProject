package com.zl.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.zl.util.FileUtil;

public class TestFileUpLoadServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public TestFileUpLoadServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�����������(����request�б���)
		//�ж��Ƿ�Ϊmultipart/form-data���ұ���Ϊpost���ύ��ʽ
		boolean isMulipart = ServletFileUpload.isMultipartContent(request);
		if(isMulipart){
			//���Ż�ȡrequest�е�����
			FileItemFactory factory=new DiskFileItemFactory();
			//upload����request�е�����
			ServletFileUpload upload=new ServletFileUpload(factory);
			try {
				//��ȡrequest�����е�����(����������:��ͨ(��file)���ļ�(file)),���浽list��
				List<FileItem> list = upload.parseRequest(request);
				//������ȡ���е��ֶ�����
				for (FileItem fileItem : list) {
					//��ȡ����Ϊ��ͨ�ֶ�(��ȡ�ļ��ֶ�)
					if(!fileItem.isFormField()){
						InputStream is = fileItem.getInputStream();//��ȡ���ϴ��ļ�����
						//���������·��
						ServletContext application = request.getSession().getServletContext();
						String tomcatPath = application.getRealPath("/upload");
						tomcatPath+="/"+request.getSession().getId()+System.currentTimeMillis()+fileItem.getName();
						//д�뵽ָ��λ��
						FileUtil.StreamWritePath(is, tomcatPath);
					}
				}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//����request�е�����
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
