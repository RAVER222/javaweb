package cn.itcaset.dataSource.JdbcTemplate;


import cn.Util.JDBCUtil;
import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;
import org.springframework.jdbc.core.JdbcTemplate;

/*
*  JDBCTemplate入门
* */

public class JdbcTemplateDemo {
    public static void main(String[] args) {
      //1.导入jar包
      //2.创建JDBCTemplate对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());
      //3.调用方法
        String sql ="update teacher set name=? where id =? ";
        int update = template.update(sql, "小芳", 2);
        System.out.println(update);
    }
}
