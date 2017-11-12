package com.zl.test;

import java.util.List;
import java.util.Scanner;

import com.zl.bean.User;
import com.zl.dao.UserDao;
import com.zl.util.PageUtil;

public class Test2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int pageCode =  input.nextInt();
		UserDao dao = new UserDao();
		List<User> list = dao.queryAllByPage((pageCode-1)*PageUtil.NEWSDETAIL_COUNT);
		for (User user : list) {
			System.out.println(user.getId()+"-"+user.getUsername());
		}
	}
}
