package wiki.laona.factory.method;

/**
 * @author laona
 * @description JSON 配置
 * @date 2021-12-08 20:28
 **/
public class JsonRuleConfigParserFactory implements IRuleConfigParserFactory{
    @Override
    public IRuleConfigParser createParser() {
        System.out.println("JsonRuleConfigParserFactory.createParser");
        return null;
    }
}
