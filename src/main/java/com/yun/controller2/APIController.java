package com.yun.controller2;

import com.yun.dao.AdminDao;
import com.yun.model.admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
public class APIController {

    private AdminDao adminDao;

    @Autowired
    public APIController(AdminDao adminDao){
        this.adminDao = adminDao;
    }

    @RequestMapping(value = "/rest", method = RequestMethod.GET,produces = "application/json; charset=UTF-8")
    public admin restAPITest(@RequestParam("admin_nm") String admin_nm){
        return adminDao.getAdminInfo(admin_nm);
    }

}
