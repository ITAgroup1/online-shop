package com.group1.core.admin.dao.impl;

import com.group1.core.admin.dao.AdminRepository;
import com.group1.core.admin.model.Admin;
import com.group1.core.utils.BaseRepositoryImpl;
import com.group1.core.utils.base.JpaRepository;
import com.group1.core.utils.base.impl.JPARepositoryImpl;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public class AdminRepositoryImpl extends JPARepositoryImpl<Admin,String> implements AdminRepository {
//    @Override
//    public String getTableName() {
//        return Admin.class.getName();
//    }
}
