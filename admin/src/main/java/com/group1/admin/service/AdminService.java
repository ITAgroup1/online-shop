package com.group1.admin.service;

import com.group1.core.admin.model.Admin;

public interface AdminService {
    Admin register(Admin admin);

    Admin login(Admin admin);
}
