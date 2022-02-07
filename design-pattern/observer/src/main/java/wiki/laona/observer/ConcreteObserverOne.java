package wiki.laona.observer;

/**
 * @author laona
 * @description 观察者
 * @date 2022-02-07 09:43
 **/
public class ConcreteObserverOne implements Observer{
    @Override
    public void update(Message message) {
        System.out.println("ConcreteObserverOne.update ---- 消息编号: " + message.getCode() + " ，消息内容： " + message.getMsg());
    }
}
