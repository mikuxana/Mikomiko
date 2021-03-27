package cn.xana.service;

import cn.xana.pojo.Comment;
import cn.xana.utils.CommentRequest;
import cn.xana.utils.PageResult;

import java.util.Set;

public interface CommentService {
    PageResult selectComment(String aid, Integer page);
    Set<Comment> selectReply(String cid);
    Integer addComment(CommentRequest commentRequest);
    Integer delComment(CommentRequest commentRequest);
    void starComment(CommentRequest commentRequest);
}
