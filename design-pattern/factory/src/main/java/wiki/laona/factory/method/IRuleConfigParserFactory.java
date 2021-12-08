package wiki.laona.factory.method;

/**
 * @author laona
 * @description
 * @date 2021-12-08 20:27
 **/
public interface IRuleConfigParserFactory {
    /**
     * 创建 parser
     *
     * @return {@link  IRuleConfigParser} 规则配置转换
     */
    IRuleConfigParser createParser();
}
