package com.xbh.bos.dao;

import com.xbh.bos.domain.Subarea;

public interface SubareaDao {
    int deleteByid(String id);

    int insert(Subarea record);

    Subarea selectByid(String id);

    int updateByid(Subarea record);
}