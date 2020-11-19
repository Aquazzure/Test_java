package domain;

import java.sql.Date;

/*
* 与数据库中表字段一一对应
* JavaBean
* */
public class Emp {
    private int empno;
    private String ename;
    private String job;
    private int mgr;
    private Date hiredate;
    private int sal;
    private int comm;
    private int deptno;
    private String name;
    private String password;


    public Emp(int empno, String ename, String job, int mgr, Date hiredate, int sal, int comm, int deptno) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
        this.deptno = deptno;

    }

    public Emp(String name,String password){
        this.name=name;
        this.password=password;}


    @Override
    public String toString() {
        return "Emp{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", mgr=" + mgr +
                ", hiredate=" + hiredate +
                ", sal=" + sal +
                ", comm=" + comm +
                ", deptno=" + deptno +
                '}';
    }

    public String getName() {
        return name;
    }

    public String  getPassword(){
        return password;
    }

}
