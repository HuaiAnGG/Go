package wiki.laona.threasafe;

/**
 * @author laona
 * @description 账号线程
 * @date 2022-01-24 21:54
 **/
public class AccountThread extends Thread {
    /**
     * 账户
     */
    private Account act;

    public AccountThread(Account act) {
        this.act = act;
    }

    public Account getAct() {
        return act;
    }

    public void setAct(Account act) {
        this.act = act;
    }

    @Override
    public void run() {
        act.withDraw(5000);
    }
}
