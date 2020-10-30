package com.wyclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Demo04 {
  public static void main(String[] args) {
	  Connection conn=null;
	  Statement stmt =null;
	  ResultSet rs =null;
	  try {
		  //1.注册驱动
		  Class.forName("com.mysql.cj.jdbc.Driver");
		 //2.获取连接
		  conn =DriverManager.getConnection("jdbc:mysql:///mybatis", "root", "123456");
		 //3.编写sql语句
		  String sql = "select * from teacher";
		 //4.获取sql对象
		  stmt = conn.createStatement();
		 //5.执行sql
		  rs = stmt.executeQuery(sql);
		 //6.处理结果
		 while(rs.next()){
			 int  id= rs.getInt(1);
		  String name = rs.getString("name");
		  System.out.println("id"+id+"----"+"name"+name); 
		 }
		 
		  
	} catch (ClassNotFoundException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}finally{
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
	  
}
}
