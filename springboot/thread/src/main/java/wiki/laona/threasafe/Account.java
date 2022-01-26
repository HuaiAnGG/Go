package wiki.laona.threasafe;

/**
 * @author laona
 * @description 银行账户(安全)
 * sycnhornized 可以所同步代码块：
 * 灵活。只需要锁住共享变量即可
 * <code>
 *     synchronized(线程共享对象) {
 *        // do something
 *     }
 * </code>
 * sycnhornized 可以在实例方法中使用:
 * 表示共享对象一定是 this，并期额同步代码块是整个方法体
 * <code>
 *     private synchronized test() {
 *        // do something
 *     }
 * </code>
 * sycnhornized 还可以在静态方法使用:
 * 表示找类锁，类锁永远只有一把，创建一百个对象也只有一把锁
 * <code>
 *     public static synchronized test() {
 *          // do something
 *     }
 * </code>
 * <p></p>
 * 类锁：只有一把
 *
 * @date 2022-01-24 21:50
 **/
@SuppressWarnings("all")
public class Account {

    private final Object obj = new Object();

    private String actNo;
    private double balance;

    public Account(String actNo, double balance) {
        this.actNo = actNo;
        this.balance = balance;
    }

    /**
     * 取款的方法
     * synchronized 保证了线程的安全，想要保证在某一个状态下只有共享某个数据的线程共享
     * 对于银行账户而言，账号是共享的(即当前类是共享，this 表示当前类)
     * <p>
     * synchronized 可以锁当前对象，可以锁当前实例变量。
     * 线程共享当前类对象，类对象中的实例变量只是针对当前类共享，故锁实例变量等于锁对象。
     * 或者说，当前线程共享类只有一个实例变量，获取当前实例变量对象锁的时候就是给实例对象加锁，使得对于当前共享锁=实例变量对象锁
     * <p>
     * synchronized
     *
     * @param money 取多少钱
     */
    public void withDraw(double money) {
        // synchronized (this) {
        //     double before = this.getBalance();
        //     double after = before - money;
        //     try {
        //         Thread.sleep(1000);
        //     } catch (InterruptedException e) {
        //         e.printStackTrace();
        //     }
        //     System.out.println(Thread.currentThread().getName() + " 账号：" + this.actNo + " 取款:" + money + ",之后的余额 =
        //     " + after);
        //     this.setBalance(after);
        // }
        synchronized (obj) {
            double before = this.getBalance();
            double after = before - money;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 账号：" + this.actNo + " 取款:" + money + ",之后的余额 = " + after);
            this.setBalance(after);
        }
    }

    /**
     * synchronized 放在实例方法中，锁的是 this，这里只能是锁 this ，
     * 整个方法都需要同步，会无故扩大锁范围，导致执行效率变低。这种方法不常用。
     * 如果共享的对象就是 this，并且需要同步代码块是整个方法体，建议使用锁方法体。
     * <p>
     * 如果使用局部变量的话建议使用：StringBuilder，StringBuilder 不存在线程安全问题。StringBuffer 效率较低
     * ArrayList 是非线程安全的
     * Vector 是线程安全的
     * HashMap HashSet 是非线程安全的
     * HashTable 是线程安全的
     *
     * @param money 金额
     */
    public synchronized void withDrawSync(double money) {
        double before = this.getBalance();
        double after = before - money;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 账号：" + this.actNo + " 取款:" + money + ",之后的余额 = " + after);
        this.setBalance(after);
    }

    public String getActNo() {
        return actNo;
    }

    public void setActNo(String actNo) {
        this.actNo = actNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
