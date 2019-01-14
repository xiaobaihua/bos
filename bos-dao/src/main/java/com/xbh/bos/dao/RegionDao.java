package com.xbh.bos.dao;

import com.xbh.bos.domain.Region;

public interface RegionDao {
    int deleteByid(String id);

    int insert(Region record);

    Region selectByid(String id);

    int updateByid(Region record);
}