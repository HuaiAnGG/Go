package wiki.laona.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author laona
 * @description deptProvider启动类
 * @date 2022-03-26 14:40
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class DeptProvider9801 {

    public static void main(String[] args) {
        SpringApplication.run(DeptProvider9801.class, args);
    }
}
