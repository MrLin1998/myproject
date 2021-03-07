package JDBC;

import java.sql.*;

public class DBUtil {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private DBUtil(){}
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone = GMT","root","123456");
    }
    public static void Close(ResultSet rs, Statement ps,Connection cn){
        if (rs!= null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (ps!= null) {
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (cn!= null) {
            try {
                cn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
