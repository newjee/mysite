package com.poscodx.mysite.repository;

import com.poscodx.mysite.vo.SiteVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SiteRepository {

    @Autowired
    private SqlSession sqlSession;

    public SiteVo find() {
        return sqlSession.selectOne("site.getSite");
    }

    public void update(SiteVo vo) {
        System.out.println(vo + "<<<<<repo");

        sqlSession.update("site.updateSite", vo);
    }
}
