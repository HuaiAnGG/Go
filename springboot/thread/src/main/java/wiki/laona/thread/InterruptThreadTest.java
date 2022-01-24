package wiki.laona.thread;

/**
 * @author laona
 * @description 中断(唤醒)睡眠的线程
 * @date 2022-01-24 13:01
 **/
@SuppressWarnings("all")
public class InterruptThreadTest {

    public static void main(String[] args) {
        System.out.println("InterruptThreadTest.main");
        Thread t1 = new Thread(new MyRunnable3());
        t1.start();
        System.out.println("InterruptThreadTest. go on 1");
        
        try {
            /* sleep() 是静态方法，执行状态跟对象无关，故而在执行 t1.sleep() 之后，t1线程也不会睡眠 */
            t1.sleep(5 * 1000);
        }catch (InterruptedException ignored){
        }
        
        System.out.println("InterruptThreadTest.go on 2");
        /* 正在睡眠中的线程可以使用 thread#interrupt() 方法中断睡眠线程，从而唤醒线程 */
        t1.interrupt();
        System.out.println("InterruptThreadTest. interrpt t1 thread");
    }
}


/**
 * 睡一年的线程
 * 
 * 使用 interrupt 终止一个正在休眠的线程
 */
class MyRunnable3 implements Runnable {
    @Override
    public void run() {
        System.out.println("MyRunnable3.run");
        try {
            // 睡一年
            Thread.sleep(1000 * 60 * 24 * 365);
        } catch (InterruptedException ignored) {
        }
        System.out.println("MyRunnable3.end");
    }
}
