package cn.xana.service.impl;

import cn.xana.mapper.ACGMapper;
import cn.xana.pojo.ACGRec;
import cn.xana.service.ACGService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ACGServiceImpl implements ACGService {

    @Autowired
    private ACGMapper acgMapper;
    @Override
    public List<ACGRec> selectBangumi(Integer size) {
        String c = "where yyyy<=2020 ";
        return acgMapper.selectBangumi(c, size);
    }



    @Override
    public List<ACGRec> selectGame(Integer size) {
        return acgMapper.selectGame(size);
    }

    @Override
    public List<ACGRec> selectBangumiLatest(Integer size) {
        String c = "where yyyy<=2020 ";
        return acgMapper.selectBangumi(c, size);
    }

/*    @Override
    public List<ACGRec> selectLunbo() {
        return acgMapper.selectLunbo();
    }*/
}
