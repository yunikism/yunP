package com.yun.visitor.service;

import com.yun.test.dao.AdminDao;
import com.yun.test.model.admin;
import com.yun.visitor.dao.VisitorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class VisitorService {

    @Autowired
    private VisitorDao visitorDao;

    public admin insertVisitor(Map<String,Object> param) {
        return visitorDao.insertVisitor(param);
    }

    public List<Map<String, Object>> selectVisitorList(Map param) {
        return visitorDao.selectVisitorList(param);
    }


}
