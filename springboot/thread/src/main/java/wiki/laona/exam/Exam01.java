package wiki.laona.exam;

import java.util.Objects;

/**
 * @author laona
 * @description 面试题: 问t2 需要等待 t1线程执行结束后才能获得锁吗？
 * 不需要。因为t2 线程执行的是 doOther 方法，
 * 该方法不是线程同步的，无需等待 t1 线程执行完 doSome 方法释放锁之后才去执行 doOther 方法
 * @create 2022-01-27 00:14
 **/
public class Exam01 {

    public static void main(String[] args) {
        MyClass mc = new MyClass();
        MyThread t1 = new MyThread(mc, Constant.THREAD_1);
        MyThread t2 = new MyThread(mc, Constant.THREAD_2);

        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}

interface Constant{
    String THREAD_1 = "T1";
    String THREAD_2 = "T2";
}

class MyThread extends Thread {

    private final MyClass mc;

    public MyThread(MyClass mc, String threadName) {
        super(threadName);
        this.mc = mc;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        if (Objects.equals(Constant.THREAD_1, name)) {
            mc.doSome();
            return;
        }
        mc.doOther();
    }
}


class MyClass {
    public synchronized void doSome() {
        System.out.println("start do some things");
        try {
            Thread.sleep(1000 * 3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end do some things");
    }

    public void doOther() {
        System.out.println("do other thing ");
    }
}
