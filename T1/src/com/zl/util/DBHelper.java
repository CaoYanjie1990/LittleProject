package com.zl.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * ����ģʽ(����ĳһ����Ķ���ʵ�����ڳ������й�����ֻ����һ��)
 */
public class DBHelper {

	private DBHelper() {
	}

	private static DBHelper dbhelper = null;
	// ��ȡ�����ļ�
	private static Properties pt = new Properties();

	public static DBHelper getInstance() {
		if (dbhelper == null)
			dbhelper = new DBHelper();
		return dbhelper;
	}

	/**
	 * ��̬��ֻ��ִ��һ��
	 */
	static {
		// ���������ļ�
		try {
			pt.load(DBHelper.class.getClassLoader().getResourceAsStream("jdbc.properties"));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		/**
		 * 1:����������
		 */
		try {
			System.out.println(pt.getProperty("driver.class"));
			Class.forName(pt.getProperty("driver.class"));
		} catch (ClassNotFoundException e) {
			System.err.println("�������������,�޷��ҵ�����");
			e.printStackTrace();
		}

	}
	/**
	 * ��ȡ����
	 * @return
	 */
	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(pt.getProperty("jdbc.url"), pt.getProperty("jdbc.user"), pt.getProperty("jdbc.password"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	/**
	 * �ͷ���Դ
	 */
	public void close(Connection con,Statement st,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(st!=null){
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void close(Connection con,Statement st){
		this.close(con, st, null);
	}

}
