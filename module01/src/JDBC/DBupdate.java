package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBupdate {
    public static void main(String[] args) {
        Connection cn=null;
        PreparedStatement ps=null;
        try{
        cn=DBUtil.getConnection();
        cn.setAutoCommit(false);
        String sql="update userinfo set password=?where name=?";
        ps=cn.prepareStatement(sql);
        ps.setString(1,"789");
        ps.setString(2,"张三");
        int count=ps.executeUpdate();
        cn.commit();
            System.out.println(count);
        }catch(Exception e){
            if(cn!=null){
                try {
                    cn.rollback();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }finally {
            DBUtil.Close(null,ps,cn);
        }
    }
}
