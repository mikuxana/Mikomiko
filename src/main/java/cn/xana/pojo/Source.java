package cn.xana.pojo;


import lombok.Data;

@Data
public class Source {
    Integer id;
    // 资源id
    String aid;
    // 云盘
    String cloudpan;
    // 提取密码
    String cloudPass;
    // 解压密码
    String releasePass;
    // 链接
    String src;
}
