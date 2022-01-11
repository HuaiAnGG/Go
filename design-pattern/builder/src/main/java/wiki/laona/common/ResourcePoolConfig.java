package wiki.laona.common;

import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

/**
 * @author laona
 * @description 资源连接池配置
 * @date 2022-01-11 09:41
 **/
public class ResourcePoolConfig {
    /**
     * 最大连接数
     */
    private static final int DEFAULT_MAX_TOTAL = 1 << 3;
    /**
     * 最大空闲数
     */
    private static final int DEFAULT_MAX_IDLE = 1 << 3;
    /**
     * 最小空闲数
     */
    private static final int DEFAULT_MIN_IDLE = 0;

    private String name;
    private int maxTotal = DEFAULT_MAX_TOTAL;
    private int maxIdle = DEFAULT_MAX_IDLE;
    private int minIdea = DEFAULT_MIN_IDLE;

    public ResourcePoolConfig(String name, Integer maxTotal, Integer maxIdle, Integer minIdea) {
        if (!StringUtils.hasText(name)) {
            throw new IllegalArgumentException("name should not be empty");
        }
        this.name = name;
        
        if (!ObjectUtils.isEmpty(maxTotal)) {
            if (maxTotal <= 0) {
                throw new IllegalArgumentException("maxTotal should be positive");
            }
            this.maxTotal = maxTotal;
        }
        
        if (!ObjectUtils.isEmpty(maxIdle)) {
            if (maxIdle < 0) {
                throw new IllegalArgumentException("maxTotal should not be negative");
            }
            this.maxIdle = maxIdle;
        }

        if (!ObjectUtils.isEmpty(minIdea)) {
            if (minIdea < 0) {
                throw new IllegalArgumentException("maxTotal should not be negative");
            }
            this.minIdea = minIdea;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(int maxTotal) {
        this.maxTotal = maxTotal;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public int getMinIdea() {
        return minIdea;
    }

    public void setMinIdea(int minIdea) {
        this.minIdea = minIdea;
    }
}
