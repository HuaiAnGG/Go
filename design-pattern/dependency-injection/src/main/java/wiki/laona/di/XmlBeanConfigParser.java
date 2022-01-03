package wiki.laona.di;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import java.io.InputStream;
import java.util.List;

/**
 * @author laona
 * @description xml 文件解析成 bean
 * @create 2022-01-03 14:06
 **/
public class XmlBeanConfigParser implements BeanConfigParser {
    private static final String ROOT = "beans";
    private static final String BEAN = "bean";

    @Override
    public List<BeanDefinition> parse(InputStream inputStream) throws ParserConfigurationException {
        try {
            String content = null;
            // todo: explain xml file

            return null;
        }catch (Exception e){
            throw new ParserConfigurationException("parse xml configuration file failed: " + e.getMessage());
        }
    }

    @Override
    public List<BeanDefinition> parse(String configContent) {
        // todo: explain xml file
        return null;
    }
}
