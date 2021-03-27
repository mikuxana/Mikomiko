package cn.xana.mapper;
import cn.xana.pojo.Game;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface GameMapper{
    static String sel = "select id, title, pic, sellTime, tags, des1, views, comments FROM games LEFT JOIN statistics ON games.id=statistics.aid ",
            ord = "ORDER BY sellTime DESC, views DESC, comments DESC ";

    @Select(sel+"where tags like '%${tag}%' "+ord)
    List<Game> selectbyTag(@Param("tag") String tag);

    @Select(sel+"where title like '%${key}%' or tags like '%${key}%' or des1 like '%${key}%' "+ord)
    List<Game> selectByKey(@Param("key") String key);

    @Select("select id, title, des1, des2, tags from games where id like #{id}")
    Game selectById(String id);

    @Select(sel+ord)
    List<Game> select();
}
