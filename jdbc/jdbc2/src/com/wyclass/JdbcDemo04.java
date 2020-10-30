package com.wyclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.wyclass.itcast.Emp.Blog;
import com.wyclass.util.JDBCUtils;

public class JdbcDemo04 {
	public static void main(String[] args) {
	 List<Blog> list = new JdbcDemo04().findAll();
      Iterator<Blog> it = list.listIterator();
      while (it.hasNext()) {
		System.out.println(it.next());
	  }
	}
	
	public List<Blog> findAll(){
		Connection conn =null;
		Statement stmt =null;
		ResultSet rs =null;
		List<Blog> list =null;
		try {
		    conn=JDBCUtils.getConnection();
			//3.编写Sql语句
			String sql="select * from blog";
			//4.创建Conn驱动
		     stmt =conn.createStatement(); 
		    //5.执行sql语句
		     rs = stmt.executeQuery(sql);
		     Blog blog=null;
		    list = new ArrayList<>();
		    while(rs.next())
		    {
		      String id=rs.getString("id");
		      String title = rs.getString("title");
		      String author = rs.getString("author");
		      Date  create_time =rs.getDate("create_time");
		      int   views  = rs.getInt("views");
		      blog = new Blog();
		      blog.setId(id);
		      blog.setTitle(title);
		      blog.setAuthor(author);
		      blog.setCreate_time(create_time);
		      blog.setViews(views);
		      list.add(blog);
		    }		   	    
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			JDBCUtils.close(rs, stmt, conn);
		}
		return list;
		
	}

}
