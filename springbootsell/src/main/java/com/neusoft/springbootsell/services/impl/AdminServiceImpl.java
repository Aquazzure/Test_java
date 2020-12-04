package com.neusoft.springbootsell.services.impl;

import com.neusoft.springbootsell.dataobject.Admin;
import com.neusoft.springbootsell.repository.AdminRepository;
import com.neusoft.springbootsell.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository repository;

    @Override
    public Admin findByAdminNameAndPassword(String adminName, String password) {
        return repository.findByAdminNameAndPassword(adminName,password);
    }

}
