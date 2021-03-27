package cn.xana.service.impl;

import cn.xana.mapper.BangumiMapper;
import cn.xana.pojo.Bangumi;
import cn.xana.pojo.Comment;
import cn.xana.service.BangumiService;
import cn.xana.utils.BangumiRequest;
import cn.xana.utils.PageRequest;
import cn.xana.utils.PageResult;
import cn.xana.utils.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BangumiServiceImpl implements BangumiService {

    @Autowired
    private BangumiMapper bangumiMapper;

    @Override
    public PageResult selectByKey(String key, Integer page) {
        PageHelper.startPage(page, 7);
        List<Bangumi> bangumiList = bangumiMapper.selectByKey(key);
        return PageUtils.getPageResult(PageInfo.of(bangumiList));
    }

    @Override
    public PageResult selectPage(BangumiRequest bangumiRequest, PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNum(), 48);
        List<Bangumi> bangumiList = bangumiMapper.selectRequest(bangumiRequest);
        return PageUtils.getPageResult(PageInfo.of(bangumiList));
    }

    @Override
    public Bangumi selectById(String id) {
        Bangumi bangumi = bangumiMapper.selectById(id);
        bangumi.setEpisodeList(bangumiMapper.selectByBid(id));
        return bangumi;
    }
}
