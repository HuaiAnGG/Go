package wiki.laona.factory.simple;

import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.util.List;

/**
 * @author laona
 * @description 简单工厂
 * @date 2021-12-08 20:11
 **/
public class RuleConfigSource {

    public List<Object> load() {
        String configName = "vector";
        List<Object> list = RuleConfigParseFactory.createList(configName);
        if (null == list) {
            throw new InvalidParameterException("参数错误");
        }
        return list;
    }
}
