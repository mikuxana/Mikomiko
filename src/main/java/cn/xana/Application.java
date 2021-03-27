package cn.xana;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//@EnableConfigurationProperties(BeanMaker.class)
@MapperScan("cn.xana.mapper")
public class Application {
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
