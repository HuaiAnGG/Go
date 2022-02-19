package wiki.laona.eventbus;

import java.lang.reflect.Method;

/**
 * @author laona
 * @description
 * @create 2022-02-08 21:49
 **/
public class ObserverAction {
    private Object object;
    private Method method;

    public ObserverAction(Object object, Method method) {
        this.object = object;
        this.method = method;
    }

    /**
     * 其中 event 是 method 方法的参数
     *
     * @param event 事件
     */
    public void execute(Object event) {
        try {
            method.invoke(object, event);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
