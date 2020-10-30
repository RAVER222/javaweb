package cn.itcaset.dataSource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

/*
*
*   c3p0的演示
*
*
* */
public class C3P0Demo01 {
    public static void main(String[] args) {
        //1.创建数据库连接池对象
        DataSource ds= new ComboPooledDataSource();
    }
}
