package wiki.laona.factory.method;

/**
 * @author laona
 * @description 资源规则配置
 * @date 2021-12-08 20:36
 **/
public class RuleConfigSource {

    public RuleConfig load(String ruleConfigFilePath) throws Exception {
        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);
        
        IRuleConfigParserFactory parserFactory = null;
        if ("json".equalsIgnoreCase(ruleConfigFileExtension)) {
            parserFactory = new JsonRuleConfigParserFactory();
        }else if ("xml".equalsIgnoreCase(ruleConfigFileExtension)) {
            parserFactory = new XmlRuleConfigParserFactory();
        }else if ("yaml".equalsIgnoreCase(ruleConfigFileExtension)) {
            parserFactory = new YamlRuleConfigParserFactory();
        }else if ("properties".equalsIgnoreCase(ruleConfigFileExtension)) {
            parserFactory = new PropertiesRuleConfigParserFactory();
        }else {
            throw new Exception("不支持该类型");
        }
        
        String configText = "";
        IRuleConfigParser parser = parserFactory.createParser();
        return parser.parse(configText);

    } 
    
    public RuleConfig load2(String type) throws Exception {
        String ruleConfigFileExtension = getFileExtension(type);

        IRuleConfigParserFactory parserFactory 
                = RuleConfigParserFactoryMap.getParserFactory(ruleConfigFileExtension);
        if (parserFactory == null) {
            throw new Exception("不支持当前格式");
        }
        
        String configText = "";
        IRuleConfigParser parser = parserFactory.createParser();
        return parser.parse(configText);
    }

    private String getFileExtension(String ruleConfigFilePath) {
        return "json";
    }
}
