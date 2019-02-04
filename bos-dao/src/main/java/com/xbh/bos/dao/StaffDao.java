package com.xbh.bos.dao;

import com.xbh.bos.domain.Staff;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

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
    @Select("SELECT * FROM bc_staff WHERE id = #{arg0}")
    Staff selectByid(String id);

    @Select("SELECT deltag FROM bc_staff WHERE id = #{agr0}")
    String getDeltagByid(String id);

    @Update("UPDATE bc_staff SET deltag = #{arg1} WHERE id = #{arg0}")
    int updateDelTagByid(String id, String deltag);

    @Override
    @Select("SELECT * FROM bc_staff LIMIT #{arg0},#{arg1}")
    List<Staff> getRecordListLimit(Integer stack, Integer end);

    @Override
    @Select("select count(*) from bc_staff")
    Integer getTotal();
}