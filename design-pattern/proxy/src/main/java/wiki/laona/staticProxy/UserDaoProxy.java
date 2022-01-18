package wiki.laona.staticProxy;

/**
 * @author laona
 * @description 代理类
 * @date 2022-01-17 14:32
 **/
public class UserDaoProxy implements IUserDao{
    
    private final IUserDao userDao;

    public UserDaoProxy(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        System.out.println("静态代理 ----- 开始");
        userDao.save();
        System.out.println("静态代理 ----- 结束");
    }

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        IUserDao proxy = new UserDaoProxy(userDao);
        proxy.save();
    }
}
