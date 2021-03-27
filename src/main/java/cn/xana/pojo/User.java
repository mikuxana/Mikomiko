package cn.xana.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.management.ObjectName;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name="users")
public class User extends SysUser{

    private String gender;
    private String smart;
    private String email;
    private Date birthday;
    private Date signUpTime;
}
