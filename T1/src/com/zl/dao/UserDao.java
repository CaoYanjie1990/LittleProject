package com.zl.dao;

import java.util.ArrayList;
import java.util.List;

import java.sql.*;

import com.zl.bean.User;
import com.zl.util.DBHelper;
import com.zl.util.PageUtil;

public class UserDao {
	DBHelper db = DBHelper.getInstance();

	// ��ѯ
	public List<User> queryAll() {
		// ����ֵ
		List<User> list = new ArrayList<User>();
		Connection con = db.getConnection();
		String sql = "select * from user";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// ������
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			while (rs.next()) {
				// ÿ�ν��붼��һ������,ÿһ�ж�Ӧһ���ñ�����Ӧ��javaBeanһ������
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

	// ���
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

	// ����������
	public int queryAllCount() {
		Connection con = db.getConnection();
		String sql = "select count(1) from user";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// ������
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			rs.next();
			return rs.getInt(1);// ������
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	// ��ѯ
	public List<User> queryAllByPage(int page) {
		// ����ֵ
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
		// ������
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			while (rs.next()) {
				// ÿ�ν��붼��һ������,ÿһ�ж�Ӧһ���ñ�����Ӧ��javaBeanһ������
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
	 * �����û���Ų�ѯ�û���ϸ��Ϣ
	 * @param id �û����
	 * @return
	 */
	public User queryUserById(int id) {
		// ����ֵ
		Connection con = db.getConnection();
		String sql = "select * from user where id = ?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// ������
		ResultSet rs = null;
		User user = new User();
		try {
			rs = ps.executeQuery();
			while (rs.next()) {
				// ÿ�ν��붼��һ������,ÿһ�ж�Ӧһ���ñ�����Ӧ��javaBeanһ������
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
