package com.yun.test.dao;

import com.yun.test.model.admin;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDao {

    @Autowired
    private SqlSession sqlSession;

    @Autowired
    public AdminDao(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }

    public admin getAdminInfo(String admin_nm){
        return sqlSession.selectOne("admin.getAdminList",admin_nm);
    }

}
