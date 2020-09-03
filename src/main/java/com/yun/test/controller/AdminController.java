package com.yun.test.controller;

import com.yun.test.model.admin;
import com.yun.test.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


//@RequestMapping("/home")
@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;


    @RequestMapping(value  = "/home/home.do")
    public String home(ModelMap modelmap) {
        modelmap.addAttribute("author","codingTest");
        String admin_nm = "이굥의";

        admin admin = new admin();
        admin = adminService.getAdminInfo(admin_nm);

        String memo = admin.getAdmin_memo();

        modelmap.addAttribute("memo" , memo);

        return "home/home";
    }

    @RequestMapping(value  = "/test/test.do")
    public String testMove(ModelMap modelmap) {

        String admin_nm = "이굥의";
        admin admin = new admin();
        admin = adminService.getAdminInfo(admin_nm);

        String nm = admin.getAdmin_nm();

        modelmap.addAttribute("nm" , nm);

        return "test/test";
    }


}
