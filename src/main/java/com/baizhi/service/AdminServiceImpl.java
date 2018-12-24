package com.baizhi.service;

import com.baizhi.entity.Admin;
import com.baizhi.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper am;
    @Override
    public Admin queryOne(Admin admin) {
        Admin a = am.selectOne(admin);
        if(a==null) throw new RuntimeException("账户或密码有误！");
        return a;
    }

    @Override
    public void update(Admin admin) {
        am.updateByPrimaryKey(admin);
    }

}
