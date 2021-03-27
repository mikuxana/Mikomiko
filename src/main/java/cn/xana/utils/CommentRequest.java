package cn.xana.utils;


import lombok.Data;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "comments")
@NameStyle(Style.normal)
public class CommentRequest {
    String cid;
    Integer uid;
    String aid;
    String commentText;
    Date commentTime;
    String replyId="0";
    Integer stars=0;
}
