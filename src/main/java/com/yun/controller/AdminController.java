package com.yun.controller;

import com.yun.model.admin;
import com.yun.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



//@RequestMapping("/home")
@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;


    @RequestMapping(value  = "/home")
    public String home(ModelMap modelmap) {
        modelmap.addAttribute("author","codingTest");
        String admin_nm = "이굥의";

        admin admin = new admin();
        admin = adminService.getAdminInfo(admin_nm);

        String memo = admin.getAdmin_memo();

        modelmap.addAttribute("memo" , memo);

        return "home";
    }


}
