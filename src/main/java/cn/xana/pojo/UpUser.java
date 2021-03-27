package cn.xana.pojo;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class UpUser extends User{
    Date upTime;
    List<ACG> upAcgs;
}
