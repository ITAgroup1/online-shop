package com.group1.admin.dao.impl;

import com.group1.admin.dao.AdminRepository;
import com.group1.core.entity.admin.Admin;
import com.group1.core.utils.base.impl.JPARepositoryImpl;
import org.springframework.stereotype.Repository;

@Repository
public class AdminRepositoryImpl extends JPARepositoryImpl<Admin,String> implements AdminRepository {
    @Override
    public Admin update(Admin admin,String id) {
        Admin result = entityManager.find(Admin.class,id);
        result.setLoginName(admin.getLoginName());
        result.setPassword(admin.getPassword());
        entityManager.persist(result);
        return result;
    }
//    @Override
//    public String getTableName() {
//        return Admin.class.getName();
//    }
}
