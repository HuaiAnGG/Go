package wiki.laona.transaction.collect;

/**
 * @author laona
 * @description
 * @create 2021-11-12 21:11
 **/
public class Task {
    private Integer code;
    private String name;

    public Task(Integer code) {
        this.code = code;
    }

    public Task(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

