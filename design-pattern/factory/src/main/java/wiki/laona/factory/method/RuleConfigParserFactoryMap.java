package wiki.laona.factory.method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author laona
 * @description 工厂的工厂
 * @date 2021-12-08 20:47
 **/
public class RuleConfigParserFactoryMap {
    /**
     * 创建对象的 map 
     */
    private static final Map<String, IRuleConfigParserFactory> CACHED_FACTORIES = new HashMap<>(1 << 4);
    
    static {
        CACHED_FACTORIES.put("json", new JsonRuleConfigParserFactory());
        CACHED_FACTORIES.put("xml", new XmlRuleConfigParserFactory());
        CACHED_FACTORIES.put("yaml", new YamlRuleConfigParserFactory());
        CACHED_FACTORIES.put("properties", new PropertiesRuleConfigParserFactory());
    }
    
    public static IRuleConfigParserFactory getParserFactory(String type) {
        if (type == null || type.isEmpty()) {
            return null;
        }
        IRuleConfigParserFactory parserFactory = CACHED_FACTORIES.get(type);
        return parserFactory;
    }
}
