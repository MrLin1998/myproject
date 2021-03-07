package JDBC;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class logintest {
    public static void main(String[] args) {
        //初始化界面
        Map<String, String> userinfo = init();
        boolean loginsucceed=login(userinfo);
        System.out.println(loginsucceed?"连接成功":"连接失败");
    }

    private static boolean login(Map<String,String> userinfo) {
        //连接数据库
        boolean loginsucceed=false;
        ResultSet rs=null;
        //Statement st=null;
        PreparedStatement ps=null;
        Connection cn=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone = GMT","root","123456");
            //st=cn.createStatement();
            //String sql="select * from userinfo where name='"+userinfo.get("username")+"'and password='"+userinfo.get("password")+"'";
            //rs=st.executeQuery(sql);
            String sql="select * from userinfo where name=?and password=?";
            ps=cn.prepareStatement(sql);
            ps.setString(1,userinfo.get("username"));
            ps.setString(2,userinfo.get("password"));
            rs=ps.executeQuery();
            if(rs.next()){
                loginsucceed=true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if ( cn!= null) {
                try {
                    cn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return loginsucceed;
    }

    private static Map<String, String> init() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入用户名");
        String username = scanner.nextLine();
        System.out.println("输入密码");
        String password = scanner.nextLine();
        HashMap<String, String> userinfo = new HashMap<>();
        userinfo.put("username",username);
        userinfo.put("password",password);
        return userinfo;
    }
}