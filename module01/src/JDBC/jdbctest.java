package JDBC;

import java.sql.*;

public class jdbctest {
    ResultSet resultSet=null;

    public static void main(String[] args)  {
        Statement statement =null;
        Connection connection=null;
        ResultSet resultSet =null;
        try{

            //注册驱动第一种
            //Class.forName("com.mysql.cj.jdbc.Driver");
            //注册驱动第二种
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //获取连接
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone = GMT","root" ,"123456" );
            //获取数据库操作对象
            statement = connection.createStatement();
            //执行SQL
            String sql="select sname from student";
            resultSet = statement.executeQuery(sql);
            // 处理查询结果集
            while (resultSet.next()){
                String sname=resultSet.getString("sname");
                System.out.println(sname);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        //关闭资源
        finally {
           if(resultSet!=null) {
               try {
                   resultSet.close();
               } catch (SQLException throwables) {
                   throwables.printStackTrace();
               }
           }
           if(statement!=null) {
                   try {
                       statement.close();
                   } catch (SQLException throwables) {
                       throwables.printStackTrace();
                   }
               }
           if(connection!=null) {
                       try {
                           connection.close();
                       } catch (SQLException throwables) {
                           throwables.printStackTrace();
                       }
                   }

           }
        }

    }

