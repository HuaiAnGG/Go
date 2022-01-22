package wiki.laona.thread;

/**
 * @author laona
 * @description 实现 runnable 接口
 * @create 2022-01-23 01:56
 **/
public class RunnableTest {

    public static void main(String[] args) {
        Runnable runnable = new MyRunnableImpl();
        Thread thread = new Thread(runnable);
        thread.start();

        for (int i = 0; i < Constants.COUNT; i++) {
            System.out.println(Thread.currentThread().getName() + ": 当前计数 = " + i);
        }
    }
}


/**
 * 实现 Runnable 接口
 */
class MyRunnableImpl implements Runnable {

    @Override
    public void run() {
        int count = Constants.COUNT;
        while (--count > 0) {
            System.out.println(Thread.currentThread().getName() + ": 当前计数 = " + count);
        }
    }

}

/**
 * 常量类
 */
interface Constants{

    /**
     * 计数器，数目需要大一点，不然结果会展示成顺序执行
     */
    int COUNT = 200;
}
