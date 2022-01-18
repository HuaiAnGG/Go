package wiki.laona.staticProxy;

/**
 * @author laona
 * @description
 * @date 2022-01-17 14:31
 **/
public class UserDao implements IUserDao{
    @Override
    public void save() {
        System.out.println("UserDao 保存接口实现方法");
    }
}
