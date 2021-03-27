package cn.xana.service.impl;
import cn.xana.mapper.GameMapper;
import cn.xana.pojo.Game;
import cn.xana.service.GameService;
import cn.xana.utils.PageResult;
import cn.xana.utils.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GameServiceImpl implements GameService {
    @Autowired
    private GameMapper gameMapper;


    @Override
    public Game selectById(String id) {
        Game game = gameMapper.selectById(id);
        return game;
    }

    @Override
    public PageResult select(Integer page) {
        PageHelper.startPage(page, 7);
        List<Game> gameList = gameMapper.select();
        return PageUtils.getPageResult(PageInfo.of(gameList));
    }

    @Override
    public PageResult selectByTag(String tag, Integer page) {
        PageHelper.startPage(page, 7);
        List<Game> gameList = gameMapper.selectByKey(tag);
        return PageUtils.getPageResult(PageInfo.of(gameList));
    }

    @Override
    public PageResult selectPage(String tag, String key,  Integer page) {
        PageHelper.startPage(page, 7);
        List<Game> gameList = key==null? gameMapper.selectbyTag(tag): gameMapper.selectByKey(key);
        return PageUtils.getPageResult(PageInfo.of(gameList));
    }

    @Override
    public PageResult selectByKey(String key, Integer page) {
        PageHelper.startPage(page, 7);
        List<Game> gameList = gameMapper.selectByKey(key);
        return PageUtils.getPageResult(PageInfo.of(gameList));
    }

}
