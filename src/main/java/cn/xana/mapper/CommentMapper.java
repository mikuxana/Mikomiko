package cn.xana.mapper;
import cn.xana.pojo.Comment;
import cn.xana.utils.CommentRequest;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import java.util.List;

@Repository
public interface CommentMapper extends Mapper<CommentRequest>{
    @Select("SELECT c1.stars, c1.cid cid, u1.username cuser, u1.uid cuserId, u1.pic cPic, u2.username ruser, u2.uid ruserId,  c1.commentText cText, c1.commentTime cTime\n" +
            "from comments c1 INNER JOIN comments c2 ON c1.replyId=c2.cid INNER JOIN users u1 ON c1.uid=u1.uid INNER JOIN users u2 ON c2.uid=u2.uid\n" +
            "where c2.cid like #{cid} " +
            "order by cTime desc")
    List<Comment> selectReply(String cid);

    @Select("SELECT c.stars, c.cid cid, c.uid cuserId, u.username cuser, u.pic cPic, c.commentTime cTime, c.commentText cText \n" +
            "FROM comments  c INNER JOIN users u ON c.uid=u.uid\n" +
            "where c.replyId=0 and c.aid like #{aid}\n" +
            "ORDER BY c.stars desc, cTime desc")
    List<Comment> selectComment(String aid);

    @Update("UPDATE comments SET stars = #{star} WHERE cid like #{cid}")
    void starComment(Integer star, String cid);
}
