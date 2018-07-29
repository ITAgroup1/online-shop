package com.group1.core.admin.dao;

import com.group1.core.admin.model.Admin;
import com.group1.core.utils.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends BaseRepository<Admin,String> {
}
