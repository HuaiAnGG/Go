package wiki.laon.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author laona
 * @description Eureka 启动类 9702
 * @date 2022-03-30 22:18
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication9702 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication9702.class, args);
    }
}
