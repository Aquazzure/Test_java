package test1;

import domain.Emp;
import utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo04 {
    //调用JDBCUtils进行工具类操作
    public static List<Emp> findAll2() throws Exception {
        List<Emp> list = new ArrayList<Emp>();
        Connection conn= JDBCUtils.getConnection();
        String sql="select * from emp";
        Statement stmt=conn.createStatement();
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
       JDBCUtils.close(rs,stmt,conn);
        return list;
    }

    public static void main(String[] args) throws Exception {
//        List<Emp> empList = findAll();
        List<Emp> empList = findAll2();
        for(Emp e:empList){
            System.out.println(e);
        }

    }


}
