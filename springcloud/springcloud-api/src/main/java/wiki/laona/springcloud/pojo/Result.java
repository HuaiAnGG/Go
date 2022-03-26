package wiki.laona.springcloud.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author laona
 * @description 统一返回结果
 * @date 2022-03-26 16:54
 **/
@Data
public class Result<T> implements Serializable {

    /**
     * 响应码
     */
    private Integer code;
    /**
     * 提示信息
     */
    private String message;
    /**
     * 请求状态
     */
    private Boolean success;
    /**
     * 响应体
     */
    private T data;

    public static <T> Result<T> ERROR(){
        return new Result<>(ResponseEnum.ERROR.getMsg(), null, ResponseEnum.ERROR);
    }

    public static <T> Result<T> ERROR(T data){
        return new Result<>(ResponseEnum.ERROR.getMsg(), data, ResponseEnum.ERROR);
    }

    public static <T> Result<T> ERROR(String message, T data){
        return new Result<>(message, data, ResponseEnum.ERROR);
    }

    public static <T> Result<T> SUCCESS() {
        return new Result<T>(ResponseEnum.SUCCESS.getMsg(), null, ResponseEnum.SUCCESS);
    }

    public static <T> Result<T> SUCCESS(T data) {
        return new Result<T>(data, ResponseEnum.SUCCESS);
    }

    public static <T> Result<T> SUCCESS(String message, T data) {
        return new Result<T>(message, data, ResponseEnum.SUCCESS);
    }

    private Result(T data, ResponseEnum response) {
        this(response.getMsg(), data, response);
    }

    private Result(String message, T data, ResponseEnum response) {
        this(response.getCode(), message, response.getSuccess(), data);
    }

    private Result(Integer code, String message, Boolean success, T data) {
        this.code = code;
        this.message = message;
        this.success = success;
        this.data = data;
    }
}
