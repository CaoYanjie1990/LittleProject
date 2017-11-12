package com.zl.filter;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.zl.bean.User;
import com.zl.util.DateUtil;
import com.zl.util.FileUtil;

/**
 * 检测添加用户时,传入的用户详细信息是否包含敏感字
 */
public class DisableCharacterFilter implements Filter {

	public void destroy() {
		System.out.println("销毁");
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// 获取request和response
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		// 获取用户的详细信息
		User user = new User();
		getParamByMultipart(request, user);
		// 敏感字列表
		List<String> list = FileUtil
				.getCharacterList("F:\\summer\\file\\character.txt");
		// 判断是否包含敏感字
		boolean isTrue = find(user.getDetail(), list);
		// 处理敏感字
		user.setDetail(replaceCharacter(user.getDetail(), list));
		// 接着向下走
		request.setAttribute("user", user);
		arg2.doFilter(arg0, arg1);
		/*
		 * arg2.doFilter(arg0, arg1); if(isTrue){ request.setAttribute("msg",
		 * "<script>alert('用户信息包含敏感字!')</script>");
		 * request.getRequestDispatcher("user/addUser.jsp").forward(request,
		 * response); }else{ //接着向下走 request.setAttribute("user", user);
		 * arg2.doFilter(arg0, arg1); }
		 */
	}

	private void getParamByMultipart(HttpServletRequest request, User user) {
		// 判断是否为Multipart请求
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			/**
			 * 准备解析Multipart/form-data类型的request
			 */
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			/**
			 * 开始解析request,并且获取传递过来的所有数据
			 */
			List<FileItem> list = null;// 接收所有的input标签传入的值
			try {
				list = upload.parseRequest(request);
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				// 处理list
				for (FileItem fileItem : list) {
					// 是普通字段
					if (fileItem.isFormField()) {
						if ("username".equals(fileItem.getFieldName())) {
							user.setUsername(fileItem.getString("UTF-8"));
						} else if ("password".equals(fileItem.getFieldName())) {
							user.setPassword(Integer.valueOf(fileItem
									.getString("UTF-8")));
						} else if ("address".equals(fileItem.getFieldName())) {
							user.setAddress(fileItem.getString("UTF-8"));
						} else if ("birthday".equals(fileItem.getFieldName())) {
							user.setBirthday(DateUtil.getDate(fileItem
									.getString("UTF-8")));
						} else if ("gender".equals(fileItem.getFieldName())) {
							user.setGender(fileItem.getString("UTF-8")
									.charAt(0));
						} else if ("detail".equals(fileItem.getFieldName())) {
							user.setDetail(fileItem.getString("UTF-8"));
						}
					} else {
						// 文件字段
						if ("userPic".equals(fileItem.getFieldName())) {
							// 获取文件的输入流
							InputStream is = fileItem.getInputStream();
							// 获取需要写入的路径
							// application代表了tomcat中当前项目
							ServletContext application = request.getSession()
									.getServletContext();
							String tomPath = application.getRealPath("/");
							String picPath = "upload/"
									+ request.getSession().getId()
									+ System.currentTimeMillis()
									+ fileItem.getName();
							user.setUserPic(picPath);
							/**
							 * 执行写入
							 */
							FileUtil.StreamWritePath(is, tomPath + picPath);
						}
					}
				}
			} catch (Exception e) {
			}

		}
	}

	/**
	 * 根据用户传入的详细信息判断用户信息是否包含敏感字
	 * 
	 * @param detail
	 *            用户传入的详细信息
	 * @param list
	 *            敏感字列表
	 * @return
	 */
	private boolean find(String detail, List<String> list) {
		boolean isFind = false;
		for (String string : list) {
			if (detail.indexOf(string) != -1) {
				isFind = true;
				break;
			}
		}
		return isFind;
	}
	private String replaceCharacter(String detail, List<String> list) {
		for (String string : list) {
			// 找到敏感字,将该敏感字使用**
			detail = detail.replace(string, "**");
		}
		return detail;
	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("初始化");
	}

}
