package com.wyclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo {
	public static void main(String[] args) throws SQLException {
	     	Statement stmt=null;
		    Connection conn=null;
		//1.注册驱动
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2.定义sql
			String sql = "insert into teacher(id,name) value (2,'小明')";
			//3.获取Connection对象
			conn = DriverManager.getConnection("jdbc:mysql:///mybatis", "root","123456");			
			//4.获取执行sql的对象 Statement
	      	 stmt = conn.createStatement();
	      	//5.执行sql
	      	int count = stmt.executeUpdate(sql); //影响的行数
	      	//6.处理结果
	      	System.out.println(count);
	      	if(count>0){
	      		System.out.println("添加成功!");
	      	}
	      	else{
	      		System.out.println("添加失败!");
	      	}
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			/*
			 *   stmt.close()
			 *   7.释放资源
			 *   避免空指针异常
			 * */
			if(stmt!=null){
				try{
					stmt.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			
			if(conn!=null){
				try{
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
	}

}
