package wiki.laona.dynamicProxy;

/**
 * @author laona
 * @description
 * @date 2022-01-17 15:40
 **/
public class UserDao implements IUserDao{
    @Override
    public void save() {
        System.out.println("动态代理 -- save");
    }
}
