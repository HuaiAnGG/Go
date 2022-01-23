package wiki.laona.thread;

/**
 * @author laona
 * @description 匿名内部类方法实现
 * @create 2022-01-23 14:31
 **/
@SuppressWarnings("all")
public class RunnableAnnoyTest {

    public static void main(String[] args) {
        /* 匿名内部类 */
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 200; i++) {
                    System.out.println(Thread.currentThread().getName() + " = " + i);
                }
            }
        });

        thread.start();

        for (int i = 0; i < 200; i++) {
            System.out.println(Thread.currentThread().getName() + " = " + i);
        }
    }
}
