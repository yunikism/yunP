package com.yun.travel.controller;

import com.yun.test.model.admin;
import com.yun.test.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


//@RequestMapping("/home")
@Controller
public class TravelController {

    @Autowired
    private AdminService adminService;


    @RequestMapping(value  = "/travel/mongol.do")
    public String moveMongol(ModelMap modelmap) {

        return "travel/mongol";
    }

    @RequestMapping(value  = "/travel/laos.do")
    public String moveLaos(ModelMap modelmap) {

        return "travel/laos";
    }

    @RequestMapping(value  = "/travel/okinawa.do")
    public String moveOkinawa(ModelMap modelmap) {

        return "travel/okinawa";
    }

    @RequestMapping(value  = "/travel/jeju.do")
    public String moveJeju(ModelMap modelmap) {

        return "travel/jeju";
    }

    @RequestMapping(value  = "/travel/love.do")
    public String moveLove(ModelMap modelmap) {

        return "travel/love";
    }

    @RequestMapping(value  = "/travel/map.do")
    public String moveMap(ModelMap modelmap) {

        return "travel/map";
    }


}
