package cn.xana.service.impl;

import cn.xana.mapper.UserMapper;
import cn.xana.pojo.SysUser;
import cn.xana.pojo.UpUser;
import cn.xana.pojo.User;
import cn.xana.service.UserService;
import cn.xana.utils.PageRequest;
import cn.xana.utils.PageResult;
import cn.xana.utils.PageUtils;
import cn.xana.utils.PasswordUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service("userService")
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public User findById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> findAll() {
        return userMapper.selectAll();
    }

    @Override
    public Integer insert(User user) {
     /*   user.setPassword(PasswordUtils.encode(user.getPassword()));*/
        return userMapper.insert(user);
    }


    @Override
    public User findUser(User user){
        return userMapper.selectOne(user);
    }

    @Override
    public List<User> findUserList(User user) {
        return userMapper.select(user);
    }

    @Override
    public User login(String username, String password) {
        /*String pass = PasswordUtils.encode(password);*/
        List<User> UserList = userMapper.login(username, password);
        if(UserList==null || UserList.size()==0)
            return null;
        return UserList.get(0);
    }
    @Override
    public UpUser selectByAid(String table, String aid) {
        return userMapper.selectByAid(table, aid);
    }

    @Override
    public PageResult selectPage(PageRequest pageRequest) {

        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);

        List<User> sysMenus = this.findAll();

        PageInfo pageInfo = new PageInfo(sysMenus);
        return PageUtils.getPageResult(pageInfo);
    }

}
