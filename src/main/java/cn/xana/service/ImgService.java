package cn.xana.service;

import cn.xana.pojo.Img;
import org.springframework.stereotype.Service;

import java.util.List;



@Service("imgService")
public interface ImgService {
    List<Img> select(Integer Id);
    List<Img> selectH(Integer Id);

    /*由aid获取截图*/
    List<String> selectByAid(String aid);
}
