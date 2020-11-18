package test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestJDBC {
    public static void main(String[] args){
        String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String dbURL="jdbc:sqlserver://127.0.0.1:1433; DatabaseName=Library";
        String userName="sa";
        String userPwd="0504";
        try {
            // 连接数据库
            Class.forName(driverName);
            Connection con=DriverManager.getConnection(dbURL,userName,userPwd);
            String sql="update account set balance=600 where id=1";
            Statement stmt=con.createStatement();
            int i =stmt.executeUpdate(sql);
            if(i==1){
                System.out.println("更新成功");
            }else{
                System.out.println("失败");
            }
            stmt.close();
            con.close();
        }catch(Exception e) {
            System.out.println("连接数据库失败！" + e);
        }
    }

}
