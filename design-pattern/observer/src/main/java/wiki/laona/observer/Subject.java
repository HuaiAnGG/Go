package wiki.laona.observer;

/**
 * @author laona
 * @description 被观察者
 * @date 2022-02-07 09:34
 **/
public interface Subject {
    void registerObserver(Observer observer);
    
    void removeObserver(Observer observer);
    
    void notifyObservers(Message message);
}
