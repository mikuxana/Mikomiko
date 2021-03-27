package cn.xana.service.impl;

import cn.xana.mapper.CommentMapper;
import cn.xana.pojo.Comment;
import cn.xana.service.CommentService;
import cn.xana.utils.CommentRequest;
import cn.xana.utils.PageResult;
import cn.xana.utils.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public PageResult selectComment(String aid, Integer page) {
        PageHelper.startPage(page, 15);
        List<Comment> commentList = commentMapper.selectComment(aid);
        for (Comment comment : commentList) {
            comment.setReplyList(this.selectReply(comment.getCid()));
        }
        return PageUtils.getPageResult(PageInfo.of(commentList));
    }

    @Override
    public Set<Comment> selectReply(String cid) {
        HashSet<Comment> commentHashSet = new HashSet<>();
        getReply(commentHashSet, cid);
        return commentHashSet;
    }

    @Override
    public Integer addComment(CommentRequest commentRequest) {
        return commentMapper.insert(commentRequest);
    }

    @Override
    public Integer delComment(CommentRequest commentRequest) {
        return commentMapper.delete(commentRequest);
    }

    @Override
    public void starComment(CommentRequest commentRequest) {
        commentMapper.starComment(commentRequest.getStars(), commentRequest.getCid());
    }

    private void getReply(Set<Comment> commentSet, String cid){
        List<Comment> commentList = commentMapper.selectReply(cid);
        for (Integer i = 0; i < commentList.size(); ++i) {
            commentSet.add(commentList.get(i));
            getReply(commentSet, commentList.get(i).getCid());
        }
    }
}
