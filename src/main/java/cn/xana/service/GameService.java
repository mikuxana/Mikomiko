package cn.xana.service;
import cn.xana.pojo.Game;
import cn.xana.utils.Page;
import cn.xana.utils.PageRequest;
import cn.xana.utils.PageResult;

import java.util.List;

public interface GameService {

    Game selectById(String id);

    PageResult select(Integer page);
    PageResult selectByTag(String tag, Integer page);
    PageResult selectByKey(String key, Integer page);

    PageResult selectPage(String tag, String key, Integer page);


}
