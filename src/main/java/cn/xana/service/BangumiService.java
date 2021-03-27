package cn.xana.service;

import cn.xana.pojo.Bangumi;
import cn.xana.pojo.Comment;
import cn.xana.utils.BangumiRequest;
import cn.xana.utils.PageRequest;
import cn.xana.utils.PageResult;

import java.util.List;
import java.util.Set;

public interface BangumiService {
    PageResult selectByKey(String key,Integer page);
    PageResult selectPage(BangumiRequest bangumiRequest, PageRequest pageRequest);
    Bangumi selectById(String id);
}
