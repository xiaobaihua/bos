package com.xbh.bos.dao;

import com.xbh.bos.domain.Staff;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.SelectKey;

public interface StaffDao {
    int deleteByid(String id);

    @Insert("insert into bc_staff(id,name, telephone,haspda,station,standard) values(#{id},#{name},#{telephone},#{haspda},#{station},#{standard})")
    @SelectKey(keyProperty = "id", resultType = String.class, before = true,
        statement = "select replace(uuid(), '-', '') as id from dual")
    int save(Staff record);

    Staff selectByid(String id);

    int updateByid(Staff record);
}