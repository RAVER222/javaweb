package cn.itcaset.dataSource.Druid;

import cn.Util.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DruidDemo0 {
    public static void main(String[] args) throws SQLException {
        /*
        *   完成一个添加的操作
        * */
        //1.获取连接
        Connection conn = JDBCUtil.getconnection();
        //2.编写sql
        String sql ="insert into teacher values(?,?)";
        //3.获取PreparedStatement对象
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //4.给sql赋值
        pstmt.setInt(1,2);
        pstmt.setString(2,"小明");
        int count = pstmt.executeUpdate();
        if(count>0)
        {
            System.out.println("执行成功!");
        }else {
            System.out.println("执行失败!");
        }
        JDBCUtil.close(pstmt,conn);
    }
}
