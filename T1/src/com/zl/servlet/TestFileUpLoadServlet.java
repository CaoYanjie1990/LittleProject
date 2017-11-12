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
		//处理传入的数据(都在request中保存)
		//判断是否为multipart/form-data并且必须为post的提交方式
		boolean isMulipart = ServletFileUpload.isMultipartContent(request);
		if(isMulipart){
			//接着获取request中的数据
			FileItemFactory factory=new DiskFileItemFactory();
			//upload分析request中的数据
			ServletFileUpload upload=new ServletFileUpload(factory);
			try {
				//获取request中所有的数据(分两种类型:普通(非file)和文件(file)),保存到list中
				List<FileItem> list = upload.parseRequest(request);
				//便利获取所有的字段数据
				for (FileItem fileItem : list) {
					//获取不是为普通字段(获取文件字段)
					if(!fileItem.isFormField()){
						InputStream is = fileItem.getInputStream();//获取到上传文件的流
						//计算输出的路径
						ServletContext application = request.getSession().getServletContext();
						String tomcatPath = application.getRealPath("/upload");
						tomcatPath+="/"+request.getSession().getId()+System.currentTimeMillis()+fileItem.getName();
						//写入到指定位置
						FileUtil.StreamWritePath(is, tomcatPath);
					}
				}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//解析request中的数据
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
