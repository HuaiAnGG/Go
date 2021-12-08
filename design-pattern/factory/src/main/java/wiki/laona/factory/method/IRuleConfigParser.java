package wiki.laona.factory.method;

/**
 * @author laona
 * @description 接口
 * @date 2021-12-08 20:26
 **/
public interface IRuleConfigParser {

    /**
     * 转化
     *
     * @param configText 配置文本
     * @return {@link RuleConfig} 配置规则
     */
    RuleConfig parse(String configText);
}
