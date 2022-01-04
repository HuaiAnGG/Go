package wiki.laona.di;

import cn.hutool.core.util.XmlUtil;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @author laona
 * @description xml 文件解析成 bean
 * @create 2022-01-03 14:06
 **/
public class XmlBeanConfigParser implements BeanConfigParser {
    private static final String ROOT = "beans";
    private static final String BEAN = "bean";
    private static final String ID = "id";
    private static final String CLASS_NAME = "className";
    private static final String CONSTRUCTOR_ARGS = "constructorArgs";
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

            // Document document = XmlUtil.readXML(inputStream);
            // XmlUtil.get

            // SAXReader saxReader = new SAXReader();
            // Document document = saxReader.read(inputStream);
            // Element rootElement = document.getRootElement();
            // System.out.println("rootElement.getStringValue() = " + rootElement.getText().trim());
            
            // JacksonXmlModule xmlModule = new JacksonXmlModule();
            // XmlMapper xmlMapper = new XmlMapper(xmlModule);
            // BeanDefinition beanDefinition = xmlMapper.readValue(inputStream, BeanDefinition.class);
            //
            
            // DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            // DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            // Document document = documentBuilder.parse(inputStream);
            // Element element = document.getDocumentElement();
            // NodeList beanList = element.getElementsByTagName(BEAN);
            // for (int i = 0; i < beanList.getLength(); i++) {
            //     BeanDefinition beanDefinition = new BeanDefinition();
            //     NamedNodeMap attributes = beanList.item(i).getAttributes();
            //     Node idNode = attributes.getNamedItem(ID);
            //     if (idNode != null && idNode.hasAttributes()) {
            //         String value = idNode.getNodeValue();
            //         System.out.println("value = " + value);
            //         beanDefinition.setId(value);
            //     }
            //     Node classNameNode = attributes.getNamedItem(CLASS_NAME);
            //     if (classNameNode != null && classNameNode.hasAttributes()) {
            //         String value = classNameNode.getNodeValue();
            //         System.out.println("value = " + value);
            //         beanDefinition.setClassName(value);
            //     }
            //     beanDefinitions.add(beanDefinition);
            // }
            // System.out.println("beanDefinitions = " + beanDefinitions);
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
