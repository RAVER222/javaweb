package com.wyclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo02 {

	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		
		try {
			//1.注册驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2.获取连接对象
		   conn =DriverManager.getConnection("jdbc:mysql:///mybatis", "root", "123456");
		     //3.定义sql
		   String sql = "update teacher set name ='小花' where id=2";
		   //4.获取sql对象
		   stmt = conn.createStatement();
		   //5.执行sql
		   int count = stmt.executeUpdate(sql);
		   //6.处理结果
		   System.out.println(count);
		   if(count>0){
			   System.out.println("修改成功!");
		   }else{
			  System.out.println("修改失败!"); 
		   }
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			//7.释放资源
			if(stmt!=null)
			{
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
			if(conn!=null)
			{
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
