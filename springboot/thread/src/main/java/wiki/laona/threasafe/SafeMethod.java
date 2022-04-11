package wiki.laona.threasafe;

import java.util.concurrent.Semaphore;

/**
 * @author laona
 * @description 线程安全
 * @date 2022-04-01 15:55
 **/
public class SafeMethod {

    private final Semaphore safeSemaphore = new Semaphore(2);

    public void safe() {
        try {
            // while (!safeSemaphore.tryAcquire()){
            //     // System.out.println(Thread.currentThread().getName() + "线程正在等待..");
            // }
            safeSemaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " 已经获取信号量，当前剩余的信号量是：" + safeSemaphore.availablePermits() + "，当前阻塞队列数量是：" + safeSemaphore.getQueueLength());
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + " 任务完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            safeSemaphore.release();
            System.out.println(Thread.currentThread().getName() + " 释放信号量，当前剩余的信号量是：" + safeSemaphore.availablePermits() + "，当前阻塞队列数量是：" + safeSemaphore.getQueueLength());
        }
    }
}
