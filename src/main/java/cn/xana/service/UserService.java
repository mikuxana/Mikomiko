package cn.xana.service;

import cn.xana.pojo.UpUser;
import cn.xana.pojo.User;
import cn.xana.utils.PageRequest;
import cn.xana.utils.PageResult;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;



@Service("userService")
public interface UserService {
    User findById(int id);
    List<User> findAll();
    Integer insert(User user);
    User findUser(User user);
    List<User> findUserList(User user);
    User login(String username, String password);

    UpUser selectByAid(String table, String aid);

    PageResult selectPage(PageRequest pageRequest);

}
