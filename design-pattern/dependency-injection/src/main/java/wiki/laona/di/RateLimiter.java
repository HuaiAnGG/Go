package wiki.laona.di;

import lombok.Data;

/**
 * @author laona
 * @description rateLimiter
 * @create 2022-01-02 00:40
 **/
@Data
public class RateLimiter {
    private RedisCounter redisCounter;

    public RateLimiter(RedisCounter redisCounter) {
        this.redisCounter = redisCounter;
    }

    public void test() {
        System.out.println("this is rateLimiter printer.");
    }
}
