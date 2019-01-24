package com.xbh.bos.dao;

import com.xbh.bos.domain.Decidedzone;

import java.util.List;

public interface DecidedzoneDao extends BaseDao<Decidedzone>{
    @Override
    int save(Decidedzone record);

    @Override
    Decidedzone selectByid(String id);

    @Override
    int updateByid(Decidedzone record);

    @Override
    List<Decidedzone> getRecordListLimit(Integer stack, Integer end);

    @Override
    Integer getTotal();
}