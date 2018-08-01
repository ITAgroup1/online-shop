package com.group1.admin.service.impl;

import com.group1.admin.service.AdminService;
import com.group1.core.admin.dao.AdminRepository;
import com.group1.core.admin.model.Admin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminRepository adminRepository;

    @Override
    public Admin register(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin login(Admin admin) {
        return null;
    }
}
