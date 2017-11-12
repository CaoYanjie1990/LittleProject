package com.zl.test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.zl.bean.User;
import com.zl.util.DBHelper;

public class Test1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//数据库的连接
		DBHelper db = DBHelper.getInstance();
		/**
		 *2:创建连接
		 */
		Connection con =db.getConnection();
		/**
		 * 3:执行sql
		 */
		String sql = "select * from user";		
		System.err.println(sql);
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs= ps.executeQuery();
		/**
		 * 4:处理结果集
		 */
		List<User> list = new ArrayList<User>();
		while(rs.next()){
			//每次进入都是一个新行,每一行对应一个该表所对应的javaBean一个对象
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setUsername(rs.getString("username"));
			user.setBirthday(rs.getDate("birthday"));
			user.setGender(rs.getString("gender").charAt(0));
			user.setAddress(rs.getString("address"));
			user.setPassword(rs.getInt("password"));
			list.add(user);
		}
		/**
		 * 5:关闭资源(先用后关)
		 */
		db.close(con, ps, rs);
	}
}
