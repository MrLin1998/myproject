package JDBC.pool;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtils {
    //加载配置文件
    //初始化一个连接池
    static private DataSource ds;
    static {
        Properties pro = new Properties();
        InputStream is =DBUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            pro.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        public static Connection getConnection() throws SQLException {
            return ds.getConnection();
        }
        public static DataSource getDataSource(){
        return ds;
        }
        public static void close(Connection cnn, Statement st, ResultSet rs) throws SQLException {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (cnn != null) {
                cnn.close();
            }
        }
        public  static void close(Connection cnn,Statement st) throws SQLException {
        close(cnn,st,null);
        }
}
