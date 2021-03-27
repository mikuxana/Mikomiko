package cn.xana.pojo;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class Game extends ACG{
    Date sellTime;
    String tags;
/*    List<String> pics;*/
    /*剧情简介*/
    String des1;
    /*汉化staff*/
    String des2;
    String views = "9999";
    String comments = "9999";
}
