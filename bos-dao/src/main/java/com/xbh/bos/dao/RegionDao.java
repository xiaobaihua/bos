package com.xbh.bos.dao;

import com.xbh.bos.domain.Region;

import java.util.List;

public interface RegionDao extends BaseDao<Region>{

    @Override
    int save(Region record);

    @Override
    Region selectByid(String id);

    @Override
    int updateByid(Region record);

    @Override
    List<Region> getRecordListLimit(Integer stack, Integer end);

    @Override
    Integer getTotal();
}