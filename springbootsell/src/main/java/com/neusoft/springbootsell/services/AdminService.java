package com.neusoft.springbootsell.services;

import com.neusoft.springbootsell.dataobject.Admin;
import com.neusoft.springbootsell.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;


public interface AdminService {
    //根据AdminName和password查询是否SQL中是否有该条记录
    public Admin findByAdminNameAndPassword(String adminName,String password);



}
