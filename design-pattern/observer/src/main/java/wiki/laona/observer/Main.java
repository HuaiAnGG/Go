package wiki.laona.observer;

/**
 * @author laona
 * @description
 * @date 2022-02-07 09:45
 **/
public class Main {

    public static void main(String[] args) {
        ConcreteSubject concreteSubject = new ConcreteSubject();
        
        ConcreteObserverOne observerOne = new ConcreteObserverOne();
        ConcreteObserverTwo observerTwo = new ConcreteObserverTwo();
        
        concreteSubject.registerObserver(observerOne);
        concreteSubject.registerObserver(observerTwo);
        
        Message msg1 = new Message("msg001", "消息11111");
        Message msg2 = new Message("msg002", "消息22222");
        
        concreteSubject.notifyObservers(msg1);
        concreteSubject.removeObserver(observerOne);
        concreteSubject.notifyObservers(msg2);
    }
}
