package wiki.laona.di;

import java.io.InputStream;
import java.util.List;

/**
 * @author laona
 * @description
 * @create 2022-01-03 13:35
 **/
public interface BeanConfigParser {
    /**
     * 读取配置文件转换成 {@link BeanDefinition} {#beanDefinition}
     *
     * @param inputStream io 输入流
     * @return {@link List<BeanDefinition>} #BeanDefinition 列表
     */
    List<BeanDefinition> parse(InputStream inputStream);

    /**
     * 读取配置文件转换成 {@link BeanDefinition}
     *
     * @param configContent 配置文件地址
     * @return {@link List<BeanDefinition>} #BeanDefinition 列表
     */
    List<BeanDefinition> parse(String configContent);
}
