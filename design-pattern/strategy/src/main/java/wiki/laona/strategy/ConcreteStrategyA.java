package wiki.laona.strategy;

/**
 * @author laona
 * @description 策略 a
 * @date 2022-03-21 20:51
 **/
public class ConcreteStrategyA implements Strategy{
    @Override
    public void algorithmInterface() {
        System.out.println("ConcreteStrategyA.algorithmInterface");
    }
}
