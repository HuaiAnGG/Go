package wiki.laona.observer;

/**
 * @author laona
 * @description
 * @date 2022-02-07 09:44
 **/
public class ConcreteObserverTwo implements Observer{
    @Override
    public void update(Message message) {
        System.out.println("ConcreteObserverTwo.update ---  消息编号: " + message.getCode() + " ，消息内容： " + message.getMsg());
    }
}
