package com.zl.dao;

import java.util.ArrayList;
import java.util.List;

import java.sql.*;

import com.zl.bean.User;
import com.zl.util.DBHelper;
import com.zl.util.PageUtil;

public class UserDao {
	DBHelper db = DBHelper.getInstance();

	// 查询
	public List<User> queryAll() {
		// 返回值
		List<User> list = new ArrayList<User>();
		Connection con = db.getConnection();
		String sql = "select * from user";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 处理结果
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			while (rs.next()) {
				// 每次进入都是一个新行,每一行对应一个该表所对应的javaBean一个对象
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setBirthday(rs.getDate("birthday"));
				user.setGender(rs.getString("gender").charAt(0));
				user.setAddress(rs.getString("address"));
				user.setPassword(rs.getInt("password"));
				user.setUserPic(rs.getString("userPic"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 添加
	public boolean addUser(User user) {
		Connection con = db.getConnection();
		String sql = "INSERT INTO USER(username,PASSWORD,birthday,address,gender,detail,userPic)VALUES(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setInt(2, user.getPassword());
			ps.setDate(3, new java.sql.Date(user.getBirthday().getTime()));
			ps.setString(4, user.getAddress());
			ps.setString(5, String.valueOf(user.getGender()));
			ps.setString(6, String.valueOf(user.getDetail()));
			ps.setString(7, user.getUserPic());
			int row = ps.executeUpdate();
			return row > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// 查找总数量
	public int queryAllCount() {
		Connection con = db.getConnection();
		String sql = "select count(1) from user";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 处理结果
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			rs.next();
			return rs.getInt(1);// 总数量
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	// 查询
	public List<User> queryAllByPage(int page) {
		// 返回值
		List<User> list = new ArrayList<User>();
		Connection con = db.getConnection();
		String sql = "select * from user limit ?,?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, page);
			ps.setInt(2, PageUtil.NEWSDETAIL_COUNT);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 处理结果
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			while (rs.next()) {
				// 每次进入都是一个新行,每一行对应一个该表所对应的javaBean一个对象
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setBirthday(rs.getDate("birthday"));
				user.setGender(rs.getString("gender").charAt(0));
				user.setAddress(rs.getString("address"));
				user.setPassword(rs.getInt("password"));
				user.setUserPic(rs.getString("userPic"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 根据用户编号查询用户详细信息
	 * @param id 用户编号
	 * @return
	 */
	public User queryUserById(int id) {
		// 返回值
		Connection con = db.getConnection();
		String sql = "select * from user where id = ?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 处理结果
		ResultSet rs = null;
		User user = new User();
		try {
			rs = ps.executeQuery();
			while (rs.next()) {
				// 每次进入都是一个新行,每一行对应一个该表所对应的javaBean一个对象
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setBirthday(rs.getDate("birthday"));
				user.setGender(rs.getString("gender").charAt(0));
				user.setAddress(rs.getString("address"));
				user.setPassword(rs.getInt("password"));
				user.setDetail(rs.getString("detail"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}
