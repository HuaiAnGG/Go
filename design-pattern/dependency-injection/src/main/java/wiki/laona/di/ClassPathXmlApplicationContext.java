package wiki.laona.di;

import java.io.InputStream;
import java.util.List;

/**
 * @author laona
 * @description classPathXmlApplicationContext
 * @create 2022-01-03 12:48
 **/
public class ClassPathXmlApplicationContext implements ApplicationContext {
    private BeansFactory beansFactory;

    private BeanConfigParser beanConfigParser;

    public ClassPathXmlApplicationContext(String configLocation) {
        this.beansFactory = new BeansFactory();
        this.beanConfigParser = new XmlBeanConfigParser();
        loadBeanDefinitions(configLocation);
    }

    /**
     * 加载类定义
     *
     * @param configLocation 配置文件路径
     */
    private void loadBeanDefinitions(String configLocation) {
        try (InputStream in = this.getClass().getResourceAsStream("/" + configLocation)) {
            if (in == null) {
                throw new RuntimeException("Can not find config file:" + configLocation);
            }

            System.out.printf("beans.xml file content: %s \n", in);
            List<BeanDefinition> beanDefinitions = beanConfigParser.parse(in);
            beansFactory.addBeanDefinitions(beanDefinitions);
        } catch (Exception e) {
            System.out.println("e = " + e);
        }
    }

    @Override
    public Object getBean(String beanId) {
        return beansFactory.getBean(beanId);
    }
}
