package com.forg.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtil {

	private static String userName = "loanadmin";
	private static String userPwd = "jc123456!";
	
	private static String url = "jdbc:mysql://192.168.36.211:3306/loanadmin";
	private static String driver = "com.mysql.jdbc.Driver";
	
	
	
	public static void main(String[] args) {
		DbUtil k = new DbUtil();
		k.querySelect("SELECT borrow_ext_rate FROM BORROW  ");
	}
	
	protected static boolean initDriver(String d){
		if(d != null && d.length() > 0 ){
			driver = d;
		}
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static Connection getConnect(String url,String userName,String userPwd) {
		if(!initDriver("com.mysql.jdbc.Driver")){
			return null;
		}
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, userName, userPwd);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return con;
	}
	
	public void querySelect(String sql){
		
		ResultSet rs = null;
		Statement stmt = null;
		
		Connection con = getConnect(url,userName,userPwd);
		if (con == null){
			return ;
		}
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			
			for (int i = 1;i <= rsmd.getColumnCount() ;i++){
				System.out.println(rsmd.getColumnLabel(i));
				System.out.println(rsmd.getColumnClassName(i));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return ;
		}finally{
				try {
					if(rs != null) rs.close();
					if(stmt != null) stmt.close();
					if(con != null) con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
	

}
