package wiki.laona.strategy;

/**
 * @author laona
 * @description 策略工厂
 * @date 2022-03-21 20:45
 **/
public class StrategyFactory {

    public static Strategy getStrategy(String type) {
        if (null == type || type.isEmpty()) {
            throw new IllegalArgumentException("type should not be empty.");
        }
        if (type.equals("A")) {
            return new ConcreteStrategyA();
        } else if (type.equals("B")) {
            return new ConcreteStrategyB();
        }
        return null;
    }
}
