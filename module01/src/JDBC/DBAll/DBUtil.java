package JDBC.DBAll;

import java.sql.*;

public class DBUtil {
    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
 public static Connection getConnection() throws SQLException {
      return   DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone = GMT","root","123456");
    }
public   static void close(Connection cnn, Statement st, ResultSet rs){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (st != null) {
            try {
                st.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (cnn != null) {
            try {
                cnn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public  static  void close(Connection cnn,Statement ps){
        DBUtil.close(cnn,ps,null);
    }

}
