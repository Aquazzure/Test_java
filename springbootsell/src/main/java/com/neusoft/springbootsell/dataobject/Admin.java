package com.neusoft.springbootsell.dataobject;

import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@DynamicUpdate
public class Admin {
    @Id
    @GeneratedValue
    private Integer adminId;

    //用户名
    private String adminName;

    //登陆密码
    private String password;

    public Admin() {
    }

    public Admin(String adminName, String password) {
        this.adminName = adminName;
        this.password = password;
    }
}

