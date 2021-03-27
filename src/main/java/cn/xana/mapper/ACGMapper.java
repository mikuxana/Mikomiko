package cn.xana.mapper;
import cn.xana.pojo.ACGRec;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ACGMapper {
    @Select("SELECT bg.id, bg.title, bg.pic, ur.uid upId, ur.username upName, ur.pic upPic, ud.upTime, sc.views, sc.comments FROM bangumis bg \n" +
            "LEFT JOIN statistics sc ON bg.id=sc.aid " +
            "LEFT JOIN uploads ud ON bg.id=ud.aid " +
            "LEFT JOIN users ur ON ud.uid=ur.uid ${c} " +
            "ORDER BY yyyy DESC, views DESC, comments DESC, danmakus DESC, stars DESC, favorites DESC, shares DESC "+
            "LIMIT ${size}")
    List<ACGRec> selectBangumi(String c, @Param("size") Integer size);


    @Select("SELECT ge.id, ge.title, ge.pic, ur.uid upId, ur.username upName, ur.pic upPic, ud.upTime, sc.views, sc.comments FROM games ge \n" +
            "LEFT JOIN statistics sc ON ge.id=sc.aid " +
            "LEFT JOIN uploads ud ON ge.id=ud.aid " +
            "LEFT JOIN users ur ON ud.uid=ur.uid " +
            "WHERE tags like '%' " +
            "ORDER BY views DESC, sellTime DESC, comments DESC, favorites DESC, shares DESC "+
            "LIMIT ${size}")
    List<ACGRec> selectGame(@Param("size") Integer size);

//    @Select("SELECT id, title, pic FROM `bangumis` bg " +
//            "LEFT JOIN `statistics` sc ON bg.id=sc.aid " +
//            "WHERE yyyy <= 2020 "+
//            "ORDER BY yyyy DESC, views DESC, comments DESC " +
//            "LIMIT 7;")
//    List<ACGRec> selectLunbo();
}
