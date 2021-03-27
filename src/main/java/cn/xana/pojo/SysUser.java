package cn.xana.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "sys_users")

public class SysUser {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer uid;
    private String username;
    private String password;
    private String pic="/ref/img/user-icon/default.png";
}
