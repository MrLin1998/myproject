package JDBC.DBAll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MyJDBCTest {
    public static void main(String[] args) throws SQLException {
        Connection cnn=null;
        PreparedStatement ps=null;
        try {
            cnn= DBUtil.getConnection();
           cnn.setAutoCommit(false);
           String sql="insert into student(sid,sname,age,sex) values(?,?,?,?)";
           ps=cnn.prepareStatement(sql);
           ps.setInt(1 ,166);
           ps.setString(2,"刘德华");
           ps.setInt(3,49);
           ps.setString(4,"男");
           int  count=ps.executeUpdate();
            System.out.println(count);
        }catch (Exception e){
            if (cnn != null) {
                try {
                    cnn.rollback();
                }catch (Exception e1){
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        }finally {
            if (cnn != null) {
            cnn.commit();
            }
            DBUtil.close(cnn,ps);
        }
    }
}
