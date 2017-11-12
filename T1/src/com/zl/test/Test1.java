package com.zl.test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.zl.bean.User;
import com.zl.util.DBHelper;

public class Test1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//���ݿ������
		DBHelper db = DBHelper.getInstance();
		/**
		 *2:��������
		 */
		Connection con =db.getConnection();
		/**
		 * 3:ִ��sql
		 */
		String sql = "select * from user";		
		System.err.println(sql);
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs= ps.executeQuery();
		/**
		 * 4:��������
		 */
		List<User> list = new ArrayList<User>();
		while(rs.next()){
			//ÿ�ν��붼��һ������,ÿһ�ж�Ӧһ���ñ�����Ӧ��javaBeanһ������
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
		 * 5:�ر���Դ(���ú��)
		 */
		db.close(con, ps, rs);
	}
}
