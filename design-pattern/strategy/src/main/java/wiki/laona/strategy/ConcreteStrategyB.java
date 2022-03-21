package wiki.laona.strategy;

/**
 * @author laona
 * @description 策略 B
 * @date 2022-03-21 20:52
 **/
public class ConcreteStrategyB implements Strategy{
    @Override
    public void algorithmInterface() {
        System.out.println("ConcreteStrategyB.algorithmInterface");
    }
}
