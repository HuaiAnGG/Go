package wiki.laona.di;

import cn.hutool.core.util.XmlUtil;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/**
 * @author laona
 * @description xml 文件解析成 bean
 * @create 2022-01-03 14:06
 **/
@Slf4j
public class XmlBeanConfigParser implements BeanConfigParser {
    private static final String ROOT = "beans";
    private static final String BEAN = "bean";
    private static final String ID = "id";
    private static final String CLASS_NAME = "class";
    private static final String CONSTRUCTOR_ARG = "constructor-arg";
    private static final String SCOPE = "scope";
    private static final String LAZY_INIT = "lazyInit";
    private static final String TYPE = "type";
    private static final String REF = "ref";
    private static final String ARG = "arg";


    @Override
    public List<BeanDefinition> parse(InputStream inputStream) throws ParserConfigurationException {
        try {
            List<BeanDefinition> beanDefinitions = new ArrayList<>();
            String content = null;
            // todo: explain xml file
            SAXReader reader = new SAXReader();
            Document document = reader.read(inputStream);
            Iterator<?> iter = document.getRootElement().elementIterator("bean");
            while (iter.hasNext()) {
                BeanDefinition beanDefinition = new BeanDefinition();
                Element el = (Element) iter.next();
                String id = el.attributeValue("id");
                String className = el.attributeValue("class");
                String scope = el.attributeValue("scope");
                if (Scope.SINGLETON.getScope().equals(scope)) {
                    beanDefinition.setScope(Scope.SINGLETON);
                } else {
                    beanDefinition.setScope(Scope.PROTOTYPE);
                }
                beanDefinition.setId(id);
                beanDefinition.setClassName(className);
                Iterator<Element> argsIter = el.elementIterator("constructor-arg");
                while (argsIter.hasNext()) {
                    ConstructorArg constructorArg = new ConstructorArg();
                    Element arg = argsIter.next();
                    String ref = arg.attributeValue("ref");
                    String type = arg.attributeValue("type");
                    String value = arg.attributeValue("value");
                    constructorArg.setRef(StringUtils.hasText(ref));
                    if (StringUtils.hasText(type)) {
                        Class<?> aClass = Class.forName(type);
                        if (!ObjectUtils.isEmpty(aClass)) {
                            constructorArg.setType(aClass);
                        }
                    }
                    if (StringUtils.hasText(value)) {
                        constructorArg.setArg(value);
                    }
                    beanDefinition.getConstructorArgs().add(constructorArg);
                }
                beanDefinitions.add(beanDefinition);
            }
            return beanDefinitions;
        } catch (Exception e) {
            throw new ParserConfigurationException("parse xml configuration file failed: " + e.getMessage());
        }
    }

    @Override
    public List<BeanDefinition> parse(String configContent) {
        // todo: explain xml file
        return null;
    }
}