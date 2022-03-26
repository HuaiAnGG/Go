package wiki.laona.springcloud.pojo;

/**
 * @author laona
 * @description 统一响应枚举类
 * @date 2022-03-26 17:05
 **/
public enum ResponseEnum {
    SUCCESS(200, true, "请求成功"),
    ERROR(500, false, "请求失败");

    private final Integer code;
    private final String msg;
    private final Boolean success;

    ResponseEnum(Integer code, Boolean success, String msg) {
        this.code = code;
        this.success = success;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Boolean getSuccess() {
        return success;
    }
}
