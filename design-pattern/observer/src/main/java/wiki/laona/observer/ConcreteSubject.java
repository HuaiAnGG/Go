package wiki.laona.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author laona
 * @description 被观察者实现类
 * @date 2022-02-07 09:38
 **/
public class ConcreteSubject implements Subject{
    
    private final List<Observer> observers = new ArrayList<>();
    
    @Override
    public void registerObserver(Observer observer) {
        if (observers.contains(observer)) {
            throw new RuntimeException("禁止重复注册");
        }
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Message message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
