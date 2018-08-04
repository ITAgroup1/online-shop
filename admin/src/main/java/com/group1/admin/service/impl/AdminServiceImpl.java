package com.group1.admin.service.impl;

import com.group1.admin.service.AdminService;
import com.group1.admin.dao.AdminRepository;
import com.group1.core.entity.admin.Admin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Resource(name = "adminDao")
    private AdminRepository adminRepository;

    @Override
    public Admin register(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin login(Admin admin) {
        return adminRepository.login(admin.getLoginName(), admin.getPassword());
    }
}
