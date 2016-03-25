package com.register.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBUtil {

	    private static final String url="jdbc:mysql://127.0.0.1:3306/register";
		private static final String user="root";
		private static final String password="111111";
		private static Connection conn=null;
		static{
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				 conn= DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		public static Connection getConnection() throws SQLException{
			return conn;
		}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		
		
		//测试数据库是否联通
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn= DriverManager.getConnection(url, user, password);
		Statement stmt=conn.createStatement();
		ResultSet rs= stmt.executeQuery("select id,name from hospital");
		while(rs.next())
		{
			System.out.print(rs.getInt("id")+"  ");
			System.out.println(rs.getString("name"));
		}
	}

}
