package com.group1.admin.dao.impl;

import com.group1.admin.dao.AdminRepository;
import com.group1.core.entity.admin.Admin;
import com.group1.core.utils.base.impl.JPARepositoryImpl;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository("adminDao")
public class AdminRepositoryImpl extends JPARepositoryImpl<Admin,String> implements AdminRepository {

    @Override
    public Admin login(String loginName, String password) {
        Admin admin =null;
        Query query = entityManager.createQuery("select A From Admin A Where A.loginName=:loginName and A.password=:password");
        query.setParameter("loginName", loginName);
        query.setParameter("password", password);
        List<Admin> list = query.getResultList();
        if (list.size() > 0)
            admin = list.get(0);
        return admin;
    }
}
