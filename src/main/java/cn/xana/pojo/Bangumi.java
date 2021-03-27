package cn.xana.pojo;

import lombok.Data;
import javax.persistence.Table;
import java.util.List;


@Data
@Table(name = "bangumis")
public class Bangumi extends Anime{
    String yyyy;
    String area;
    String des1;
    String des2;
    List<Episode> episodeList;
}
