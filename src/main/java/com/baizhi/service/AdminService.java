package com.baizhi.service;

import com.baizhi.entity.Admin;

public interface AdminService {
    public Admin queryOne(Admin admin);
    public void update(Admin admin);
}
