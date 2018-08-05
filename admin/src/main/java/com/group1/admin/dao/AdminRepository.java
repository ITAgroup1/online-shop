package com.group1.admin.dao;

import com.group1.core.entity.admin.Admin;
import com.group1.core.utils.base.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, String> {

    Admin login(String loginName,String password);

}
