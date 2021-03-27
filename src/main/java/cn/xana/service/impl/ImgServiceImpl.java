package cn.xana.service.impl;

import cn.xana.mapper.ImgMapper;
import cn.xana.pojo.Img;
import cn.xana.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ImgServiceImpl implements ImgService {

    @Autowired
    private ImgMapper imgMapper;

    @Override
    public List<Img> select(Integer id) {
        return imgMapper.select(id);
    }

    public List<Img> selectH(Integer id){
        return imgMapper.selectH(id);
    }

    @Override
    public List<String> selectByAid(String aid) {
        return imgMapper.selectByAid(aid);
    }
}
