package wiki.laona.dlc;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author laona
 * @description 双检锁单例
 * @create 2021-11-16 19:59
 **/
public class DclIdGenerator {
    
    private AtomicLong id = new AtomicLong(0);
    
    private static volatile DclIdGenerator instance;
    
    private DclIdGenerator(){
    }
    
    public static DclIdGenerator getInstance() {
        if (instance == null) {
            // 类级锁
            synchronized (DclIdGenerator.class) {
                if (instance == null) {
                    instance = new DclIdGenerator();
                }
            }
        }
        return instance;
    }
    
    public long getId() {
        return id.getAndIncrement();
    }
}
