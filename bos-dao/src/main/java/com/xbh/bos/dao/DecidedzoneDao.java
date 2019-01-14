package com.xbh.bos.dao;

import com.xbh.bos.domain.Decidedzone;

public interface DecidedzoneDao {
    int deleteByid(String id);

    int insert(Decidedzone record);

    Decidedzone selectByid(String id);

    int updateByid(Decidedzone record);
}