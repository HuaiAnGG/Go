package wiki.laona.lazy;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author laona
 * @description 懒汉加载
 * @create 2021-11-16 19:52
 **/
public class LazyIdGenerator {

    private AtomicLong id = new AtomicLong(0);

    private static LazyIdGenerator instance;

    private LazyIdGenerator() {
    }

    private static synchronized LazyIdGenerator getInstance() {
        if (null == instance) {
            instance = new LazyIdGenerator();
        }
        return instance;
    }

    public long getId() {
        return id.getAndIncrement();
    }
}
