package com.group1.core.admin.dao;

import com.group1.core.admin.model.Admin;
import com.group1.core.utils.BaseRepository;
import com.group1.core.utils.base.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,String> {
}
