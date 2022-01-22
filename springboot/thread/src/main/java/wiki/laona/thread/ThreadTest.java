package wiki.laona.thread;

/**
 * @author laona
 * @description 线程demo
 * @create 2022-01-23 00:56
 **/
public class ThreadTest {

    public static void main(String[] args) {
        // 创建线程
        MyThread myThread = new MyThread();
        MyThread myThread1 = new MyThread();
        // 启动线程
        myThread.start();
        myThread1.start();
    }
}


/**
 * 通过继承 Thread 实现线程
 */
class MyThread extends Thread{

    @Override
    public void run() {
        int num = 100;
        while (--num > 0) {
            System.out.println( Thread.currentThread().getName() +": 当前执行次数" + num);
        }
    }
}

