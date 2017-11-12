package com.zl.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.zl.util.Logger;

/**
 * ���������û�(session)
 */
public class OnLineUserListener implements HttpSessionListener{
	private static int onlineNums = 0;
	private Logger logger = new Logger();
	/**
	 * session����ʱ
	 */
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println(arg0.getSession().getId()+"�����ɹ�");
		onlineNums++;
		logger.info(arg0.getSession().getId()+"��¼������");
		logger.info("��ǰ��������:"+onlineNums);
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println(arg0.getSession().getId()+"���ٳɹ�");
		onlineNums--;
		logger.info(arg0.getSession().getId()+"�ǳ�������");
		logger.info("��ǰ��������:"+onlineNums);
	}

}
