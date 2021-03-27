package cn.xana.mapper;

import cn.xana.pojo.Bangumi;
import cn.xana.pojo.Episode;
import cn.xana.utils.BangumiRequest;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface BangumiMapper extends Mapper<Bangumi> {

    @Select("select DISTINCT * from bangumis where title like '%${key}%' or area like '%${key}%' or type like '%${key}%' or des1 like '%${key}%'")
    List<Bangumi> selectByKey(@Param("key") String key);

    @Select("select DISTINCT id, title, pic from bangumis where " +
            "type like '%${type}%' and " +
            "area like '%${area}%' and " +
            "yyyy like '%${yyyy}%'")
    List<Bangumi> selectRequest(BangumiRequest bangumiRequest);

    @Select("select DISTINCT id, title, des2 from bangumis where id = #{id}")
    Bangumi selectById(String id);

    @Select("select DISTINCT ind, src from plays where bangumi_id=#{bid}")
    List<Episode> selectByBid(String bid);

}
