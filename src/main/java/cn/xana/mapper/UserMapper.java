package cn.xana.mapper;

import cn.xana.pojo.UpUser;
import cn.xana.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import java.util.List;

@Repository("userMapper")
public interface UserMapper extends Mapper<User> {

    @Select("select * from users " +
            "where username=#{user} and password=#{pass}")
    List<User> login(@Param("user") String username, @Param("pass") String password);

    @Select("SELECT ur.uid, ur.username, ur.pic, ud.upTime \n" +
            "FROM ${table} bg LEFT JOIN uploads ud ON bg.id=ud.aid LEFT JOIN users ur ON ud.uid=ur.uid " +
            "WHERE bg.id like #{aid}")
    UpUser selectByAid(String table, String aid);
}
