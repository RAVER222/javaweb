package com.wyclass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.wyclass.util.JDBCUtils;

public class JDBCDemo05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入用户名!");
		String username=sc.nextLine();
		System.out.println("请输入密码");
		String password =sc.nextLine();
	    boolean  flag =new JDBCDemo05().login1(username, password); 
	    if(flag){
	    	System.out.println("登录成功!");
	    }else{
	    	System.out.println("登录失败!");
	    }	
	}
		
   public boolean login(String username,String password){
	   	   
	  if(username == null || password ==null ){
		  return false;
	  }
	  Connection conn=null;
	  Statement stmt=null;
	  ResultSet rs=null;
	  
	  try {
		  //1.获取连接
		  conn = JDBCUtils.getConnection();
		  //2.定义sql语句
		  String sql = "select * from user where username ='"+username+"'and password='"+password+"'";
	      //3.获取执行sql语句
		  stmt = conn.createStatement();
		  //4.执行查询
		   rs = stmt.executeQuery(sql);
		  //5.判断
		  return rs.next();//如果又下一行就为true
	  } catch (ClassNotFoundException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	  } catch (SQLException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	 }finally{
		 JDBCUtils.close(rs, stmt, conn);
	 }
	return false;
   }  
   
   
   /*使用preparedStatement实现*/
   
   public boolean login1(String username,String password){
   	   
		  if(username == null || password ==null ){
			  return false;
		  }
		  Connection conn=null;
		  PreparedStatement pre =null;
		  ResultSet rs=null;
		  
		  try {
			  //1.获取连接
			  conn = JDBCUtils.getConnection();
			  //2.定义sql语句
			  String sql = "select * from user where username =? and password=?";
		      //3.获取执行sql语句
			   pre = conn.prepareStatement(sql);
			   pre.setString(1, username);
			   pre.setString(2, password);
			  //4.执行查询
			   rs = pre.executeQuery();
			  //5.判断
			  return rs.next();//如果又下一行就为true
		  } catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		  } catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		 }finally{
			 JDBCUtils.close(rs, pre, conn);
		 }
		return false;
	   }  
}
