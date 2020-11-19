package test1;

import domain.Emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JDBCDemo06 {
    public static void main(String[] args) throws Exception {
        List<Emp> empList = findAll();

        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名：");
        String name=sc.next();
        System.out.println("请输入密码：");
        String password=sc.next();
        for(int i=0;i<3;i++){
            if(empList.get(i).getName().equals(name)&&empList.get(i).getPassword().equals(password)){
                System.out.println("登陆成功");
            }else{
                System.out.println("用户不存在");
            }
        }
    }

    public static List<Emp> findAll() throws Exception{
        //多态
        List<Emp> list = new ArrayList<Emp>();
        String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String dbURL="jdbc:sqlserver://127.0.0.1:1433; DatabaseName=Library";
        String userName="sa";
        String userPwd="0504";

        // 连接数据库
        //注册驱动
        Class.forName(driverName);
        //获取数据库连接对象
        Connection con= DriverManager.getConnection(dbURL,userName,userPwd);
        //查询
        String sql="select* from Info";
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery(sql); //返回查询的结果集
        rs.next();
        String name=rs.getString("name");
        String password=rs.getString("password");

        rs.close();
        stmt.close();
        con.close();

        return list;
    }


}
