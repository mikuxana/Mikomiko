package cn.xana.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class ACGRec extends ACG{
    String upId = "1001";
    String upName = "嫉妬の魔女";
    String upPic = "/ref/img/user-icon/ete.jpg";
    Date upTime = new Date();
    String views = "99999";
    String comments = "99999";
}
