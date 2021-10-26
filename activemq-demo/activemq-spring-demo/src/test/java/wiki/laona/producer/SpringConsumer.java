package wiki.laona.producer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 * @author laona
 * @description spring 和 consumer的整合, 启动程序
 * @create 2021-10-26 09:48
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-consumer.xml")
public class SpringConsumer {
    
    @Test
    public void startupListener() throws IOException {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext-consumer.xml");
        app.start();
        System.in.read();
    }
}
