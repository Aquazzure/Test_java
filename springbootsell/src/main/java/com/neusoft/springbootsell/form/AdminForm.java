package com.neusoft.springbootsell.form;

import lombok.Data;

@Data
public class AdminForm {
    private Integer adminId;

    //用户名
    private String adminName;

    //登陆密码
    private String password;

}
