package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class utilTest {
    public static void main(String[] args) {
        Connection cn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
            try {
                cn=DBUtil.getConnection();
                String sql="select * from userinfo where name=?and password=?";
                ps=cn.prepareStatement(sql);
                ps.setString(1,"张三");
                ps.setString(2,"123");
                rs=ps.executeQuery();
                if(rs.next()){
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("password"));}
            } catch (SQLException throwables) {
                throwables.printStackTrace();
        }finally {
            DBUtil.Close(rs,ps,cn);
        }
    }
}
