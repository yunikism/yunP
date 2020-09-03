package com.yun.visitor.controller;

import com.yun.common.util.CommonUtils;
import com.yun.test.model.admin;
import com.yun.test.service.AdminService;
import com.yun.visitor.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


//@RequestMapping("/home")
@Controller
public class VisitorController {

    @Autowired
    private VisitorService visitorService;

    @RequestMapping(value  = "/visitor/visitorWrite.do")
    public String moveVisitorWrite(ModelMap modelmap) {

        return "visitor/visitorWrite";
    }

    @RequestMapping(value  = "/visitor/visitorList.do")
    public String moveVisitorList(HttpServletRequest request, Model model) {
        Map param = CommonUtils.getParameterMap(request);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        list = visitorService.selectVisitorList(param);

        model.addAttribute("records", list);

        return "visitor/visitorList";
    }

    @RequestMapping(value  = "/visitor/insertVisitor.do")
    public String insertVisitor(HttpServletRequest request, Model model) {

        Map param = CommonUtils.getParameterMap(request);

        System.out.println("param : " + param);
        visitorService.insertVisitor(param);
        model.addAttribute("status","success");

        return "home/home";
    }


}
