package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/*
* JDBC连接数据库工具
* */
public class JDBCUtils {
    //定义成员变量
    private static DataSource ds;
    //初始化成员变量
    static {
        try {
            Properties pro=new Properties();
            InputStream in=JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            //load()是一个Reader对象
            pro.load(in);
            ds= DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception{
         return ds.getConnection();
    }

    public static void close(Statement stmt,Connection conn){
        close(null,stmt,conn);
    }

    public static void close(ResultSet rs,Statement stmt, Connection conn){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        JDBCUtils.getConnection();
    }

}
