package cn.xana.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;

@Data
public class Img {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private String src;
}
