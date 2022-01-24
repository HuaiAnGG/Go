package wiki.laona.thread;

/**
 * @author laona
 * @description 线程测试
 * @date 2022-01-24 21:02
 **/
public class CurrentThreadTest2 {
    public static void main(String[] args) {
        System.out.println("CurrentThreadTest2.main 优先级" + Thread.currentThread().getPriority());
        printPriority();

        System.out.println("=================================");
        // yieldThread();

        System.out.println(" join  ================= start");
        Thread t2 = new Thread(new MyRunnable9(), "join线程");
        t2.start();
        try {
            System.out.println("线程 join");
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" join  ================= end");
    }

    /**
     * yield() 为线程让步
     * <p>
     * 程序设计每 100 计数，让出时间片
     */
    private static void yieldThread() {
        Thread t2 = new Thread(new MyRunnable10());
        t2.start();

        for (int i = 0; i < Constant.MAX_NUM; i++) {
            System.out.println(Thread.currentThread().getName() + " --->>>  " + i);
        }
    }

    /**
     * 打印线程优先级
     */
    private static void printPriority() {
        System.out.println("最高优先级：" + Thread.MAX_PRIORITY);
        System.out.println("正常优先级：" + Thread.NORM_PRIORITY);
        System.out.println("最低优先级：" + Thread.MIN_PRIORITY);
    }
}

/**
 * yield 让出时间片，让别的线程可以抢占
 */
class MyRunnable10 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < Constant.MAX_NUM; i++) {
            // 每一百次让位一次
            if (i % 100 == 0) {
                Thread.yield();
            }
            System.out.println(Thread.currentThread().getName() + " --->>>  " + i);
        }
    }
}

/**
 * join 假如当前线程，让 join进来的线程继续执行，当 join进来的线程执行完成之后，会继续执行之前的任务
 */
class MyRunnable9 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < Constant.MAX_NUM; i++) {
            System.out.println(Thread.currentThread().getName() + " =======  " + i);
        }
    }
}

