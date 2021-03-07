package JDBC.pool;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class druidTest {
    public static void main(String[] args) throws Exception {
        //导入jar包和配置文件
        //加载配置文件
        //获取连接池对象
        Properties pr = new Properties();
        InputStream is = druidTest.class.getClassLoader().getResourceAsStream("druid.properties");
        pr.load(is);
        DataSource ds = DruidDataSourceFactory.createDataSource(pr);
        Connection cn = ds.getConnection();
        System.out.println(cn);
    }
}
