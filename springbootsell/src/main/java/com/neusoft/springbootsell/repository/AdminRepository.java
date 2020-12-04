package com.neusoft.springbootsell.repository;

import com.neusoft.springbootsell.dataobject.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {
        Admin findByAdminNameAndPassword(String adminName,String password);
}
