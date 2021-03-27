package cn.xana.service;

import cn.xana.mapper.StatisticMapper;
import cn.xana.pojo.Statistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StatisticService {
    @Autowired
    private StatisticMapper statisticMapper;

    public Statistic selectByid(String aid){
        return statisticMapper.selectById(aid);
    }

    public Integer updateByFieldWithId(String field, String aid, String val){
        return statisticMapper.updateByFieldWithId(field, aid, val);
    }
    public Integer insert(String aid){
        return statisticMapper.insert(aid);
    }


}
