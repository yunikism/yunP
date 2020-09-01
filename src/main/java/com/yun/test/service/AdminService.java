package com.yun.test.service;

import com.yun.test.dao.AdminDao;
import com.yun.test.model.admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminDao adminDao;

    public admin getAdminInfo(String admin_nm) {
        System.out.println("admin_nm : " + admin_nm);
        return adminDao.getAdminInfo(admin_nm);
    }

}
