package cn.xana.pojo;
import lombok.Data;
import java.util.List;

@Data
public abstract class ACG {
    private String id;
    private String title;
    private String pic;
/*
    private List<Source> sources;
    private List<Comment> comments;
    private UpUser upUser;
    */
}
