package wiki.laona.di;

import lombok.Data;

/**
 * @author laona
 * @description readieCounter
 * @create 2022-01-02 00:41
 **/
@Data
public class RedisCounter {
    private String ipAddress;
    private int port;

    public RedisCounter(String ipAddress, int port) {
        this.ipAddress = ipAddress;
        this.port = port;
    }
}
