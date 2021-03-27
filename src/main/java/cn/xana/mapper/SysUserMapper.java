package cn.xana.mapper;

import cn.xana.pojo.SysUser;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;


@Repository("sysUserMapper")
public interface SysUserMapper extends Mapper<SysUser> {
}
