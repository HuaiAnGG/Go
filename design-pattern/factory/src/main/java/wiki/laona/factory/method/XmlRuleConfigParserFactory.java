package wiki.laona.factory.method;

/**
 * @author laona
 * @description XML 配置
 * @date 2021-12-08 20:29
 **/
public class XmlRuleConfigParserFactory implements IRuleConfigParserFactory{
    @Override
    public IRuleConfigParser createParser() {
        System.out.println("XmlRuleConfigParserFactory.createParser");
        return null;
    }
}
