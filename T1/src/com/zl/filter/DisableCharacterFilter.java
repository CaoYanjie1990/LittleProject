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
 * �������û�ʱ,������û���ϸ��Ϣ�Ƿ����������
 */
public class DisableCharacterFilter implements Filter {

	public void destroy() {
		System.out.println("����");
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// ��ȡrequest��response
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		// ��ȡ�û�����ϸ��Ϣ
		User user = new User();
		getParamByMultipart(request, user);
		// �������б�
		List<String> list = FileUtil
				.getCharacterList("F:\\summer\\file\\character.txt");
		// �ж��Ƿ����������
		boolean isTrue = find(user.getDetail(), list);
		// ����������
		user.setDetail(replaceCharacter(user.getDetail(), list));
		// ����������
		request.setAttribute("user", user);
		arg2.doFilter(arg0, arg1);
		/*
		 * arg2.doFilter(arg0, arg1); if(isTrue){ request.setAttribute("msg",
		 * "<script>alert('�û���Ϣ����������!')</script>");
		 * request.getRequestDispatcher("user/addUser.jsp").forward(request,
		 * response); }else{ //���������� request.setAttribute("user", user);
		 * arg2.doFilter(arg0, arg1); }
		 */
	}

	private void getParamByMultipart(HttpServletRequest request, User user) {
		// �ж��Ƿ�ΪMultipart����
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			/**
			 * ׼������Multipart/form-data���͵�request
			 */
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			/**
			 * ��ʼ����request,���һ�ȡ���ݹ�������������
			 */
			List<FileItem> list = null;// �������е�input��ǩ�����ֵ
			try {
				list = upload.parseRequest(request);
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				// ����list
				for (FileItem fileItem : list) {
					// ����ͨ�ֶ�
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
						// �ļ��ֶ�
						if ("userPic".equals(fileItem.getFieldName())) {
							// ��ȡ�ļ���������
							InputStream is = fileItem.getInputStream();
							// ��ȡ��Ҫд���·��
							// application������tomcat�е�ǰ��Ŀ
							ServletContext application = request.getSession()
									.getServletContext();
							String tomPath = application.getRealPath("/");
							String picPath = "upload/"
									+ request.getSession().getId()
									+ System.currentTimeMillis()
									+ fileItem.getName();
							user.setUserPic(picPath);
							/**
							 * ִ��д��
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
	 * �����û��������ϸ��Ϣ�ж��û���Ϣ�Ƿ����������
	 * 
	 * @param detail
	 *            �û��������ϸ��Ϣ
	 * @param list
	 *            �������б�
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
			// �ҵ�������,����������ʹ��**
			detail = detail.replace(string, "**");
		}
		return detail;
	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("��ʼ��");
	}

}
