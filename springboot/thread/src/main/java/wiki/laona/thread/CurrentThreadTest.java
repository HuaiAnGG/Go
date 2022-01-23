package wiki.laona.thread;

/**
 * @author laona
 * @description 当前线程相关操作
 * @create 2022-01-23 14:53
 **/
public class CurrentThreadTest {

    public static void main(String[] args) {
        modifiedThreadName();

        currentThreadMethod2();
    }

    private static void currentThreadMethod2() {
        String name = Thread.currentThread().getName();
        System.out.println("线程名 = " + name);
    }

    /**
     * 修改线程名字
     */
    private static void modifiedThreadName() {
        MyThread2 thread2 = new MyThread2();
        // 设置名字
        thread2.setName("线程2");
        thread2.start();
        String name = Thread.currentThread().getName();
        System.out.println("线程名 = " + name);
    }
}

/**
 * 自定义线程类
 */
class MyThread2 extends Thread {

    @Override
    public void run() {
        System.out.println("MyThread2.run");
    }
}
