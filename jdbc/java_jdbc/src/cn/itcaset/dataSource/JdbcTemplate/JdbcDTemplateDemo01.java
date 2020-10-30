package cn.itcaset.dataSource.JdbcTemplate;

import cn.Util.JDBCUtil;
import cn.itcaset.dataSource.pojo.Blog;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class JdbcDTemplateDemo01 {

      private   JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());

      @Test
      public void testUpdate(){
          String sql = "update blog set title = ? where id=?";
          int count = template.update(sql, "mybaits", 1);
          System.out.println(count);
      }

      @Test
      public void testInsert(){
          String sql="insert into blog(id,title,author,create_time,views) values(?,?,?,?,?)";
          int update = template.update(sql, 5,"数据库", "张三", "2020-1-10 00:00:00", 1000);
          System.out.println(update);
      }

      @Test
      public void testDelete(){
          String sql ="delete from blog where id =?";
          int update = template.update(sql, 5);
          System.out.println(update);
      }

      @Test
      public void testMap(){
          String sql ="select * from blog where id=?";
          Map<String, Object> sm = template.queryForMap(sql,1);
          System.out.println(sm);
      }

      @Test
      public void testListMap(){
        String sql ="select * from blog";
          List<Map<String, Object>> maps = template.queryForList(sql);
          System.out.println(maps);
      }

      @Test
      public void testQuery(){
          String sql ="select * from blog";
          List<Blog> list = template.query(sql, new RowMapper<Blog>() {
              public Blog mapRow(ResultSet rs, int i) throws SQLException {
                  Blog blog = new Blog();
                  String id = rs.getString("id");
                  String title = rs.getString("title");
                  String author = rs.getString("author");
                  Date date = rs.getDate("create_time");
                  int views = rs.getInt("views");
                  blog.setId(id);
                  blog.setTitle(title);
                  blog.setAuthor(author);
                  blog.setCreate_time(date);
                  blog.setViews(views);
                  return blog;
              }
          });

          for (Blog blog : list) {
              System.out.println(blog);
          }
      }

      @Test
     public void testQuery_2(){
      String sql ="select  * from blog";
          List<Blog> list = template.query(sql, new BeanPropertyRowMapper<Blog>(Blog.class));
          for (Blog blog : list) {
              System.out.println(blog);
          }
      }

      @Test
      public void testCount(){
          String sql ="select count(id) from blog";
          Long aLong = template.queryForObject(sql, Long.class);
          System.out.println(aLong);
      }
}
