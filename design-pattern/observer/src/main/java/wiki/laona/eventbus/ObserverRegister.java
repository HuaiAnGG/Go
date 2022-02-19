package wiki.laona.eventbus;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author laona
 * @description
 * @create 2022-02-08 21:52
 **/
public class ObserverRegister {
    private final ConcurrentHashMap<Class<?>, CopyOnWriteArraySet<ObserverAction>> registers = new ConcurrentHashMap<>();

    // public void register(Object observer){
    //     Map<Class<?>, Collection<ObserverAction>> observerActions = findAllObservers();
    // }
}
