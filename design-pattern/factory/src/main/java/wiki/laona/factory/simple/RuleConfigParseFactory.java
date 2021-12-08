package wiki.laona.factory.simple;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author laona
 * @description 简单工程模式
 * @date 2021-12-08 20:11
 **/
public class RuleConfigParseFactory {
    
    public static List<Object> createList(String name) {
        List<Object> list = null;
            if ("list".equals(name)){
                list = new ArrayList<>();
            }else if ("linkedlist".equals(name)){
                list = new LinkedList<>();
            }else if ("vector".equals(name)) {
                list = new Vector<>();
            }else {
                throw new IllegalArgumentException("不支持当前参数");
            }
        return list;
    }
}
