package wiki.laona.thread;

/**
 * @author laona
 * @description 强行终止一个线程  使用 stop() 方法
 * @date 2022-01-24 13:14
 **/
public class StopThreadTest {

    public static void main(String[] args) {
        stopThread();

        System.out.println("============================");
        
        stopThreadHealthy();
    }

    /**
     * 通过添加线程执行标志位来中断线程
     * <p>
     * 推荐使用这种方法
     */
    private static void stopThreadHealthy() {
        MyRunnableTest5 r = new MyRunnableTest5();
        Thread t1 = new Thread(r);
        t1.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        r.run = false;
    }

    /**
     * 终止线程执行
     * <p>
     * 不建议使用，会丢失数据
     */
    @Deprecated
    private static void stopThread() {
        Thread t1 = new Thread(new MyRunnableTest4());
        t1.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.stop();
    }
}

/**
 * 线程类
 * <p>
 * 一个长时间任务
 */
class MyRunnableTest5 implements Runnable {

    /**
     * 线程执行标志位，true 表示该任务可以继续执行， false 表示该任务不可以继续执行
     */
    boolean run = true;

    @Override
    public void run() {
        for (int i = 0; i < Constant.NUM; i++) {
            if (run) {
                System.out.println(Thread.currentThread().getName() + " = " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;
            }
            System.out.println(Thread.currentThread().getName() + "MyRunnableTest5. 已经被终止");
            break;
        }
    }
}

/**
 * 线程类
 * <p>
 * 一个长时间任务
 */
class MyRunnableTest4 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < Constant.NUM; i++) {
            System.out.println(Thread.currentThread().getName() + " = " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


