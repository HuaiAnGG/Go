package wiki.laona.di;

import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.InputStream;
import java.util.Objects;

@Slf4j
@SpringBootTest
class DependencyInjectionApplicationTests {

    @Test
    void contextLoads() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        RateLimiter rateLimiter = (RateLimiter) applicationContext.getBean("rateLimiter");
        rateLimiter.test();
    }

    
    @Test
    public void testExplainXml() throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("beans.xml"));
        log.info(document.getText());
    }
}
