package cn.xana.pojo;


import cn.xana.utils.PageResult;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class Comment {
    String cid;
    Integer cuserId;
    String cuser;
    String cPic;
    Integer ruserId;
    String ruser;
    Date cTime;
    String cText;
    Integer stars;
    Set<Comment> replyList;
}
