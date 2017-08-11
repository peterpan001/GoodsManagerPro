package com.panli.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 数据库的连接
 * @author Peter
 *
 */
public class DbUtil {
	//数据库驱动名
	private static String DriverName = "com.mysql.jdbc.Driver";
	//数据库协议
	private static String dbUril = "jdbc:mysql://localhost:3306/db_warehouse";
	//数据库用户名
	private static String dbName = "root";
	//数据库密码
	private static String dbPassword = "panli";
	
	/**
	 * 数据库驱动的加载与数据库连接
	 * @return
	 * @throws Exception
	 */
	public static Connection getCon() throws Exception{
		Class.forName(DriverName);
		Connection conn = DriverManager.getConnection(dbUril, dbName, dbPassword);
		return conn;
	}
	/**
	 * 关闭数据库连接
	 * @param conn
	 * @throws SQLException
	 */
	public static void close(Connection conn) throws SQLException{
		if(conn!=null){
			conn.close();
		}
	}
	/**
	 * 关闭数据库连接
	 * @param conn
	 * @param rs
	 * @throws SQLException
	 */
	public static void close(Connection conn, ResultSet rs) throws SQLException{
		if(rs!=null){
			rs.close();
			if(conn!=null){
				conn.close();
			}
		}
	}
	/**
	 * 测试main()方法
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			getCon();
			System.out.println("数据库连接成功!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库连接失败!");
		}
	}
	
	
}
