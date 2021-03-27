package cn.xana.mapper;


import cn.xana.pojo.Img;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImgMapper {

    @Select("select id, src from images where id>=#{id} limit 6")
    List<Img> select(@Param("id") Integer id);

    @Select("select id, src from h_imgs where id=#{id}")
    List<Img> selectH(@Param("id") Integer id);

    @Select("select src from pics where acg_id like #{aid}")
    List<String> selectByAid (@Param("aid") String aid);
}
