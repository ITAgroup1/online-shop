package com.group1.core.admin.dao.impl;

import com.group1.core.admin.dao.AdminRepository;
import com.group1.core.admin.model.Admin;
import com.group1.core.utils.BaseRepositoryImpl;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public class AdminRepositoryImpl extends BaseRepositoryImpl<Admin,String> implements AdminRepository {
    @Override
    public String getTableName() {
        return Admin.class.getName();
    }
}
