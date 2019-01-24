package com.xbh.bos.dao;

import com.xbh.bos.domain.Staff;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

/**
 * @author Administrator
 */
public interface StaffDao extends BaseDao<Staff>{
    @Override
    @Insert("insert into bc_staff(id,name, telephone,haspda,station,standard) values(#{id},#{name},#{telephone},#{haspda},#{station},#{standard})")
    @SelectKey(keyProperty = "id", resultType = String.class, before = true,
        statement = "select replace(uuid(), '-', '') as id from dual")
    int save(Staff record);

    @Override
    Staff selectByid(String id);

    @Override
    int updateByid(Staff record);

    @Override
    List<Staff> getRecordListLimit(Integer stack, Integer end);

    @Override
    @Select("select count(*) from ")
    Integer getTotal();
}