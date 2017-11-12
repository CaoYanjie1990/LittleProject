package com.zl.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.zl.util.Logger;

/**
 * 监听在线用户(session)
 */
public class OnLineUserListener implements HttpSessionListener{
	private static int onlineNums = 0;
	private Logger logger = new Logger();
	/**
	 * session创建时
	 */
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println(arg0.getSession().getId()+"创建成功");
		onlineNums++;
		logger.info(arg0.getSession().getId()+"登录。。。");
		logger.info("当前在线人数:"+onlineNums);
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println(arg0.getSession().getId()+"销毁成功");
		onlineNums--;
		logger.info(arg0.getSession().getId()+"登出。。。");
		logger.info("当前在线人数:"+onlineNums);
	}

}
