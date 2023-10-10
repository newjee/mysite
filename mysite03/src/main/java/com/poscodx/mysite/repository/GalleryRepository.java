package com.poscodx.mysite.repository;

import com.poscodx.mysite.vo.GalleryVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class GalleryRepository {

    @Autowired
    private SqlSession sqlSession;

    public List<GalleryVo> findAll() {
        return sqlSession.selectList("gallery.findAll");
    }

    public int insert(GalleryVo vo){
        return sqlSession.insert("gallery.insert", vo);
    }
    public int deleteByNo(Long no) {
        Map<String, Long> map = new HashMap<String, Long>();
        map.put("no", no);
        return sqlSession.delete("gallery.deleteByNo", map);

    }



}
