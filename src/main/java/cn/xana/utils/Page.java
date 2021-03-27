package cn.xana.utils;

import cn.xana.pojo.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

public class Page {

    public PageResult page(PageRequest pageRequest, List<User> pojoList) {
        return PageUtils.getPageResult(getPageInfo(pageRequest, pojoList));
    }

    private PageInfo<User> getPageInfo(PageRequest pageRequest, List<User> pojoList) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        System.out.println(pageNum+" "+pageSize);
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<User>(pojoList);
    }
}
