package com.yun.visitor.dao;

import com.yun.test.model.admin;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class VisitorDao {

    @Autowired
    private SqlSession sqlSession;

    @Autowired
    public VisitorDao(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }

    public admin insertVisitor(Map<String,Object> param){
        return sqlSession.selectOne("visitor.insertVisitor",param);
    }

    public List<Map<String, Object>> selectVisitorList(Map param){
        return sqlSession.selectList("visitor.selectVisitorList",param);
    }

}
