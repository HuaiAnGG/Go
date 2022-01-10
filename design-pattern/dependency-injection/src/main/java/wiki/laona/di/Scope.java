package wiki.laona.di;

/**
 * @author laona
 * @description bean 类型
 * @create 2022-01-03 14:14
 **/
public enum Scope {
    /**
     * 单例
     */
    SINGLETON("singleton"),
    /**
     * 多例
     */
    PROTOTYPE("prototype");
    /**
     * 类型
     */
    private String scope;

    Scope(String scope) {
        this.scope = scope;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
