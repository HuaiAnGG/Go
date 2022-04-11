package wiki.laona.threasafe;

/**
 * @author laona
 * @description 信号量测试类
 * @date 2022-04-01 16:00
 **/
public class SemaphoreTest {

    public static void main(String[] args) {
        final SafeMethod safeMethod = new SafeMethod();
        for (int i = 0; i < 10; i++) {
            new Thread(safeMethod::safe).start();
            System.out.println("SemaphoreTest.main  -> " + i);
        }
    }
}
