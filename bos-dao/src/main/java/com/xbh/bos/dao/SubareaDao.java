package com.xbh.bos.dao;

import com.xbh.bos.domain.Subarea;

import java.util.List;

public interface SubareaDao extends BaseDao<Subarea>{
    @Override
    int save(Subarea record);

    @Override
    Subarea selectByid(String id);

    @Override
    int updateByid(Subarea record);

    @Override
    List<Subarea> getRecordListLimit(Integer stack, Integer end);

    @Override
    Integer getTotal();
}