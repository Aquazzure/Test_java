package test1;

import domain.Emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo03 {
    public static void main(String[] args) throws Exception {
          List<Emp> empList = findAll();
          for(Emp e:empList){
              System.out.println(e);
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
            String sql="select* from emp";
            Statement stmt=con.createStatement();
//            int i =stmt.executeUpdate(sql);
//            if(i==1){
//                System.out.println("更新成功");
//            }else{
//                System.out.println("失败");
//            }
            ResultSet rs=stmt.executeQuery(sql); //返回查询的结果集
            while(rs.next()) {
                int EMPNO=rs.getInt("EMPNO");
                String ENAME=rs.getString("ENAME");
                String JOB=rs.getString("JOB");
                int MGR=rs.getInt("MGR");
                Date HIREDATE=rs.getDate("HIREDATE");
                int SAL=rs.getInt("SAL");
                int COMM=rs.getInt("COMM");
                int DEPTNO=rs.getInt("DEPTNO");
                Emp emp = new Emp(EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO);
                list.add(emp);
            }
            rs.close();
            stmt.close();
            con.close();
            return list;
    }


}
