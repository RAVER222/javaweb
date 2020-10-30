## JDBC 定义操作性数据库的规则(接口)

- 概念: java  Database Connectivity  java数据库连接, java语言操作数据库
- JDBC本质:其实是官方定义的一套操作所有关系型数据库的规则,即接口.各个数据库厂商去实现了这个接口,提供数据库启动jar包,我们可以实现这套(JDBC)编程,真正执行的代码是驱动jar包中的实现类.







#### 快速入门

详解各个对象:

  1.DriverManager :驱动管理对象

   * 功能:

        1. 注册驱动 : 

            registerDriver(Driver driver)  注册于给定的驱动程序DriverManger

        2. 获取数据库连接  Class.forName("com.mysql.jdbc.Driver") 

      源码: static{

     ​       try{

     ​            java.sql.DriverManger.registerDriver(new Driver());

     } catch(.....){

     ​        ............................

      }

     注意:mysql5之后的驱动可以省略注册驱动的步骤

  2.Connection:数据连接对象

​     1.功能:

​             获取执行sql的对象

​                  *Statement creatatement()

​                  *PreparedStatement prepareStatement(String sql)



​    2.管理事务

​           开启事务:setAutoCommit(boolean autoCommit) 将此连接的自动提交模式设置为给定状态。 

​           提交事务:commit()

​           回滚事务:rollback()

​           

  3.Statement:结果集对象

​           执行sql

​                1.boolean execute(String sql):可以执行任务的sql    

​                2.int executeUpdate(String sql):执行DML(insert,update,delete)语句,DDL(drop,alert,create)语句         (返回值是影响的行数)

​                 3.ResultSet  executeQuery(String sql) :执行DQL(select)语句                 

  4.ResultSet:结果集对象,封装查询结果

​          boolean    next(); 游离到下一行,判断当前时候是最后一行末尾(是否有数据)

​           getxxx(); 获取数据

  注意:

​            使用步骤:

​                 1.游标向下移动一行

​                 2.判断时候有数据

​                 3.获取数据

  5.PreparedStatement :执行sql对象

​      1.SQL注入问题:在拼接是,有一些sql的特殊关键字参与字符串的拼接,会照成安全性问题

​              1.输入用户随便,输入密码 a' or 'a'='a

​              2.sql:select * from user where username ='"+username+"'and password='"+password+"'"

​    2.解决sql注入的问题:使用preparedStatement对象来解决

​    3.预编译的SQL:参数使用?作为占位符

​    4.步骤:

         - 导入驱动包->注册驱动->获取数据库连接对象->定义sql(使用?作为占位符代替参数)->获取sql语句的对象preparedStatement(String sql)->赋值(方法:setXxx())->执行sql返回结果->处理结果->释放资源

--------

 事务:一个包含多个步骤的业务操作,如果这个业务操作被事务管理,则这多个不好要么同时成功,要么同时失败!

操作:

  开启事务    提交事务    回滚事务

3.使用Connection对象来管理事务

- 开启事务:  setAutoCommit(boolean autoCommit) 将此连接的自动提交模式设置为给定状态。
- 提交事务:commit()
- 回滚事务:rollback()

### 抽取JDBC工具类 :JDBCUtil

- 简化书写
- 分析 
  - 注册驱动
  - 抽取一个方法获取连接对象
  - 抽取一个方法释放对象





数据库连接池:

​    概念:其实就是一个容器(集合),存放数据库连接池的容器

​           将系统初始化后,容器被创建,容器中会申请一些连接对象当用户来访问数据库时,从容器中获取连接对象.用户访问完之后,会将连接对象归还给容器.



- 好处:
- 1. 节约资源
  2. 用户访问高效

​    

3.实现:

   1.标准接口DataSource           javax.sql包下

​              1.方法:   获取连接 getConnection()

​                             归还连接:Connction.close() ,如果连接对象Connection是从连接池中获取的,name调用Connection.close()方法,则不会再关闭连接了,而是归还连接

​              2.一般我们不去实现它,有数据库厂商来实现

​                    1.C3P0:数据库连接池技术

​                    2.Druid:数据库连接池实现技术,由阿里巴巴提供的





### C3P0

1. 步骤 :  导入jar包->定义配置文件(c3p0.properties或者c3p0-config.xml) [路径:直接将文件放在src目录即可] ->创建核心对象:数据库连接池对象CombopooledDataSource->获取连接:getConnection



### Druid:数据库连接池实现技术

 1 .步骤:  导入jar包->定义配置文件(是properties,可以叫任意名称,可以放在任意目录下)->加载配置文件(properties)->获取数据库连接池对象:通过工程类获取(DruidDataSourceFactory)->获取连接-getConnection



2.定义工具类:

​    1.定义一个类JDBCUtils

​    2.提供静态低吗块加载配置文件,初始化连接池对象

​    3.提供方法 (获取连接方法, 释放资源 , 获取连接池的方法)





### Spring JDBC

- Spring框架对JDBC的简单封装,提供一个JDBCTemplate对象简化JDBC的开发

   

  步骤: 导入jar包 ->创建JDBCTemplate对象,依赖数据源DataSource( JdbcTemplate temolate = new JdbcTemolate(ds) ) ->调用JdbcTemplate的方法来完成CRUD的操作{

  - update():执行DML语句,   增,删,改语句
  - queryForMap():查询结果将结果集封装为map集合(只能封装一条数据)
  - queryForList():查询结果将结果集封装为list集合
  - query():查询结果,将结果封装为JavaBean对象
  - queryForObject:查询结果,将结果封装为对象

  }



##### 练习:

   * 需求:

     1.修改1号数据的属性值

     2.添加一条记录

     3.删除刚才添加的记录

     4.查询id为1的记录,将其封装为Map的集合

     5.查询所有的记录,将其封装为List

     6.查询所有记录,将其封装为Emp的对象的List集合

     7.查询总记录数