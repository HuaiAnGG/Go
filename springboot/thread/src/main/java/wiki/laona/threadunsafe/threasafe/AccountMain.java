package wiki.laona.threadunsafe.threasafe;

/**
 * @author laona
 * @description
 * @date 2022-01-24 21:56
 **/
public class AccountMain {

    public static void main(String[] args) {
        Account account = new Account("账号", 10000.0);
        AccountThread at1 = new AccountThread(account);
        AccountThread at2 = new AccountThread(account);
        
        at1.start();
        at2.start();
    }
}
