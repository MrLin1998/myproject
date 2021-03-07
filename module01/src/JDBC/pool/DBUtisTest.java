package JDBC.pool;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUtisTest {
    public static void main(String[] args) throws SQLException {

        //Connection cnn = DBUtils.getConnection();
        DataSource ds = DBUtils.getDataSource();
        Connection cnn = ds.getConnection();
        String sql="insert into student(sid,sname,age,sex) values (?,?,?,?)";
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setInt(1 ,189);
        ps.setString(2,"张学友");
        ps.setInt(3,49);
        ps.setString(4,"男");
        int count = ps.executeUpdate();
        System.out.println(count);
        DBUtils.close(cnn,ps);
    }
}
