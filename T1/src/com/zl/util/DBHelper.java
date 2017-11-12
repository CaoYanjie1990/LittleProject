package com.zl.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * 单例模式(关于某一个类的对象【实例】在程序运行过程中只能有一个)
 */
public class DBHelper {

	private DBHelper() {
	}

	private static DBHelper dbhelper = null;
	// 读取属性文件
	private static Properties pt = new Properties();

	public static DBHelper getInstance() {
		if (dbhelper == null)
			dbhelper = new DBHelper();
		return dbhelper;
	}

	/**
	 * 静态块只会执行一次
	 */
	static {
		// 加载属性文件
		try {
			pt.load(DBHelper.class.getClassLoader().getResourceAsStream("jdbc.properties"));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		/**
		 * 1:加载驱动类
		 */
		try {
			System.out.println(pt.getProperty("driver.class"));
			Class.forName(pt.getProperty("driver.class"));
		} catch (ClassNotFoundException e) {
			System.err.println("加载驱动类出错,无法找到该类");
			e.printStackTrace();
		}

	}
	/**
	 * 获取连接
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
	 * 释放资源
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
