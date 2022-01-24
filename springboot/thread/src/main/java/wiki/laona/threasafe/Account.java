package wiki.laona.threasafe;

/**
 * @author laona
 * @description 银行账户(安全)
 * @date 2022-01-24 21:50
 **/
public class Account {
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
     * @param money 取多少钱
     */
    public void withDraw(double money) {
        synchronized (this) {
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
