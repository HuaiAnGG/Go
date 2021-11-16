package wiki.laona.transaction.collect;

/**
 * @author laona
 * @description
 * @create 2021-11-12 21:13
 **/
public class Mission {
    private Integer code;
    private String content;

    public Mission(Integer code) {
        this.code = code;
    }

    public Mission(Integer code, String content) {
        this.code = code;
        this.content = content;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
