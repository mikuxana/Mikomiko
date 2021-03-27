package cn.xana.service;

import cn.xana.pojo.ACGRec;

import java.util.List;

public interface ACGService {
    List<ACGRec> selectBangumi(Integer size);
    List<ACGRec> selectGame(Integer size);
//    List<ACGRec> selectLunbo();
    List<ACGRec> selectBangumiLatest(Integer size);
}
