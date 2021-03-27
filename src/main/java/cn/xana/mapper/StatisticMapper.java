package cn.xana.mapper;

import cn.xana.pojo.Statistic;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticMapper{
    @Select("SELECT * FROM `statistics` WHERE aid=#{aid}")
    Statistic selectById(String aid);

    @Update("UPDATE `statistics` SET `${field}`=${val} WHERE aid=#{aid}")
    Integer updateByFieldWithId(String field, String aid, String val);

    @Insert("INSERT INTO `statistics` VALUE(#{aid}, 1, 0, 0, 0, 0, 0)")
    Integer insert(String aid);
}
