package com.xbh.bos.dao;

import com.xbh.bos.domain.Staff;

public interface StaffDao {
    int deleteByid(String id);

    int insert(Staff record);

    Staff selectByid(String id);

    int updateByid(Staff record);
}