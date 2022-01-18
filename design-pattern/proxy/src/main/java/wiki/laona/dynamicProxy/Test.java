package wiki.laona.dynamicProxy;

/**
 * @author laona
 * @description
 * @date 2022-01-17 15:45
 **/
public class Test {

    public static void main(String[] args) {
        IUserDao target = new UserDao();
        System.out.println("target = " + target);
        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
        System.out.println("proxy = " + proxy.getClass());
        proxy.save();
    }
}
