package wiki.laona.factory.method;

/**
 * @author laona
 * @description YAML 配置
 * @date 2021-12-08 20:33
 **/
public class YamlRuleConfigParserFactory implements IRuleConfigParserFactory{
    @Override
    public IRuleConfigParser createParser() {
        System.out.println("YamlRuleConfigParserFactory.createParser");
        return null;
    }
}
