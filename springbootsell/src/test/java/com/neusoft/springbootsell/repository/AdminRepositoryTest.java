package com.neusoft.springbootsell.repository;

import com.neusoft.springbootsell.dataobject.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminRepositoryTest {
    @Autowired
    AdminRepository repository;

    @Test
    public void save(){
        Admin admin = new Admin();
        admin.setAdminName("谢四");
        admin.setPassword("123456");
        repository.save(admin);
    }
}
