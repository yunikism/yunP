package com.yun.service;

import com.yun.dao.AdminDao;
import com.yun.model.admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminService {

    @Autowired
    private AdminDao adminDao;

    public admin getAdminInfo(String admin_nm) {
        System.out.println("admin_nm : " + admin_nm);
        return adminDao.getAdminInfo(admin_nm);
    }

}
