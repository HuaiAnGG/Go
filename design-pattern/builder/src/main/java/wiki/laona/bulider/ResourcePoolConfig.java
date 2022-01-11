package wiki.laona.bulider;

import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

/**
 * @author laona
 * @description 构建者模式
 * @date 2022-01-11 10:00
 **/
public class ResourcePoolConfig {
    private String name;
    private int maxTotal;
    private int maxIdle;
    private int minIdea;

    private ResourcePoolConfig(Builder builder) {
        this.name = builder.name;
        this.maxTotal = builder.maxTotal;
        this.maxIdle = builder.maxIdle;
        this.minIdea = builder.minIdea;
    }

    public static class Builder {
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
        
        public ResourcePoolConfig build() {
            // 逻辑校验：必填项校验、依赖关系校验、约束条件
            if (!StringUtils.hasText(name)) {
                throw new IllegalArgumentException("name should not be empty");
            }
            if (maxIdle > maxTotal) {
                throw new IllegalArgumentException("maxIdle can not bigger than maxTotal");
            }
            if (minIdea > maxTotal || minIdea > maxIdle) {
                throw new IllegalArgumentException("minIdea can not bigger than maxIdle or maxTotal");
            }
            return new ResourcePoolConfig(this);
        }

        public Builder setName(String name) {
            if (!StringUtils.hasText(name)) {
                throw new IllegalArgumentException("name should not be empty");
            }
            this.name = name;
            return this;
        }

        public Builder setMaxTotal(int maxTotal) {
            if (!ObjectUtils.isEmpty(maxTotal)) {
                if (maxTotal <= 0) {
                    throw new IllegalArgumentException("maxTotal should be positive");
                }
                this.maxTotal = maxTotal;
            }
            return this;
        }

        public Builder setMaxIdle(int maxIdle) {
            if (maxIdle < 0) {
                throw new IllegalArgumentException("maxTotal should not be negative");
            }
            this.maxIdle = maxIdle;
            return this;
        }

        public Builder setMinIdea(int minIdea) {
            if (minIdea < 0) {
                throw new IllegalArgumentException("maxTotal should not be negative");
            }
            this.minIdea = minIdea;
            return this;
        }
    }


    @Override
    public String toString() {
        return "ResourcePoolConfig{" +
                "name='" + name + '\'' +
                ", maxTotal=" + maxTotal +
                ", maxIdle=" + maxIdle +
                ", minIdea=" + minIdea +
                '}';
    }

    public static void main(String[] args) {
        ResourcePoolConfig config = new Builder()
                .setName("laona")
                .setMaxTotal(16)
                .setMaxIdle(10)
                .setMinIdea(8)
                .build();
        System.out.println("config = " + config);
    }
}
