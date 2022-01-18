package wiki.laona.dynamicProxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author laona
 * @description
 * @date 2022-01-17 15:40
 **/
public class ProxyFactory {
    /**
     * 维护一个目标对象
     */
    private final Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * 为目标对象生成代理对象
     * @return 代理对象
     */
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("开启事务 ----");
                Object returnValue = method.invoke(target, args);
                System.out.println("提交事务 ----");
                return returnValue;
            }
        } );
    }
}
