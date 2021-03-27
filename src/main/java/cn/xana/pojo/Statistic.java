package cn.xana.pojo;


import lombok.Data;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NameStyle(Style.normal)
public class Statistic {
    @Id
    String aid;
    String views="0";
    String danmakus="0";
    String comments="0";
    String stars="0";
    String favorites="0";
    String shares="0";
}
