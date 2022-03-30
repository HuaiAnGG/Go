package wiki.laona.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author laona
 * @description Eureka 启动类(可以接受注册)
 * @date 2022-03-30 21:14
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication9701 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication9701.class, args);
    }
}
