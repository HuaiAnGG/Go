package wiki.laona.observer;

/**
 * @author laona
 * @description 消息/通知类
 * @date 2022-02-07 09:37
 **/
public class Message {
    private String code;
    private String msg;

    public Message(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
