package com.wyclass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;




import com.wyclass.util.JDBCUtils;

public class JDBCDemo06 {
  public static void main(String[] args) {
	Connection conn = null;
	PreparedStatement pstmt1=null,pstmt2=null;
	
	  try {
	   //1.获取连接
	   conn = JDBCUtils.getConnection();
	   conn.setAutoCommit(false);
	   //2.定义sql
	   String sql1 = "update  bill  set  money =money - ?  where bid = ?";
	   String sql2 = "update  bill  set  money =money + ?  where bid = ?";
	   //3.获取执行sql对象
	   pstmt1 = conn.prepareStatement(sql1);
	   pstmt2 = conn.prepareStatement(sql2);
	   //4.设置参数
	   pstmt1.setDouble(1, 1000);
	   pstmt1.setInt(2, 2);
	   
	   pstmt2.setDouble(1, 1000);
	   pstmt2.setInt(2,5);
	   
	   //5.执行sql语句
	   pstmt1.executeUpdate();
	   int i =3/0;
	   pstmt2.executeUpdate();
	   conn.commit();
	   
	} catch (Exception e) {
		// TODO 自动生成的 catch 块
		try {
			conn.rollback();
		} catch (SQLException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		  e.printStackTrace();
	}finally{
		JDBCUtils.close(pstmt1, conn);
		JDBCUtils.close(pstmt2, null);
	}
  }
}
