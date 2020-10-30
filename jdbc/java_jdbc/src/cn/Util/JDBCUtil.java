package cn.Util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/*
*   Druid连接池的工具类
* */
public class JDBCUtil {
     //1,定义成员变量 DataSource
    private static DataSource ds;

    static{
        try {
           //1.加载配置文件
           Properties pro = new Properties();
           InputStream resourceAsStream = JDBCUtil.class.getClassLoader().getResourceAsStream("druid.properties");
           //2.获取资源文件
           pro.load(resourceAsStream);
           //3.获取连接池对象
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    *   获取连接
    * */
    public  static Connection getconnection() throws SQLException {
               return  ds.getConnection();
    }

    /*
    *   释放资源
    * */
    public static void close(Statement stmt,Connection conn){
      close(stmt,conn,null);
    }


    public static void close(Statement stmt, Connection conn, ResultSet rs){
        if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static DataSource getDataSource(){
        return  ds;
    }
}
