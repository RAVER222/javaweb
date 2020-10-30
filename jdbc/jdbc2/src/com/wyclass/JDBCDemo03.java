package com.wyclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo03 {
   public static void main(String[] args) {
	   Connection conn=null;
	   Statement stmt=null;
	   //1.注册驱动
	 try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		//2.获取连接对象
		 conn = DriverManager.getConnection("jdbc:mysql:///mybatis", "root", "123456");
		//3.编写sql
		 String sql ="delete from teacher where id=2";
	    //4.获取执行sql语句statement
		 stmt =conn.createStatement();
		//5.执行sql语句
		int count = stmt.executeUpdate(sql);
		
		if(count>0){
			System.out.println("执行成功!");
		}else{
			System.out.println("执行失败!");
		}
	 } catch (ClassNotFoundException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}finally{
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		if(stmt!=null)
		{
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
}
}
