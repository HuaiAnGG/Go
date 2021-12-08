package wiki.laona.factory.method;

/**
 * @author laona
 * @description properties 配置
 * @date 2021-12-08 20:34
 **/
public class PropertiesRuleConfigParserFactory implements IRuleConfigParserFactory{
    @Override
    public IRuleConfigParser createParser() {
        System.out.println("PropertiesRuleConfigParserFactory.createParser");
        return null;
    }
}
