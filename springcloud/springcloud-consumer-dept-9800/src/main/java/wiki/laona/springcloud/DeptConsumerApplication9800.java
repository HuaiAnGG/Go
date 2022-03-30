package wiki.laona.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author laona
 * @description 消费者启动类
 * @create 2022-03-26 21:50
 **/
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class DeptConsumerApplication9800 {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerApplication9800.class, args);
    }
}
