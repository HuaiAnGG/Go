package wiki.laona.hugry;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author laona
 * @description 饿汉单例
 * @create 2021-11-16 19:47
 **/
public class HungryIdGenerator {
    
    private AtomicLong id = new AtomicLong(0);
    
    private static final HungryIdGenerator instance = new HungryIdGenerator();

    private HungryIdGenerator() {
    }
    
    public static HungryIdGenerator getInstance(){
        return instance;
    } 
    
    public long getId() {
        return  id.getAndIncrement();
    }
}
