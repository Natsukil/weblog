package top.natsuki.weblog.common.utils;

import lombok.Data;
import top.natsuki.weblog.common.enums.ResponseCodeEnum;
import top.natsuki.weblog.common.exception.BizException;

//import java.io.Serial;
import java.io.Serializable;

/**
 * 通用响应对象 (进阶版)
 *
 * @author nat4u
 * @date 2025/12/10
 */
@Data
public class Response<T> implements Serializable {

    // 1. 手动指定序列化ID，防止 Redis 反序列化报错
//    @Serial
//    private static final long serialVersionUID = 1L;

    // 是否成功
    private boolean success;
    // 响应消息
    private String message;
    // 异常码
    private String errorCode;
    // 响应数据
    private T data;
    // 2. 响应时间戳 (方便排查问题)
    private long timestamp = System.currentTimeMillis();

    // =================================== 成功响应 ===================================

    public static <T> Response<T> success() {
        Response<T> response = new Response<>();
        response.setSuccess(true);
        response.setMessage(ResponseCodeEnum.SUCCESS.getErrorMessage());
        response.setErrorCode(ResponseCodeEnum.SUCCESS.getErrorCode());
        return response;
    }

    public static <T> Response<T> success(T data) {
        Response<T> response = success(); // 复用上面的逻辑
        response.setData(data);
        return response;
    }

    // =================================== 失败响应 ===================================

    // 场景 A: 也就是最通用的服务器报错
    public static <T> Response<T> fail() {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        response.setErrorCode(ResponseCodeEnum.FAIL.getErrorCode());
        response.setMessage(ResponseCodeEnum.FAIL.getErrorMessage());
        return response;
    }

    // 场景 B: 指定错误信息的失败 (比如捕获了异常 getMessage)
    public static <T> Response<T> fail(String errorMessage) {
        Response<T> response = fail();
        response.setMessage(errorMessage);
        return response;
    }

    // 场景 C: 指定错误码和信息的失败
    public static <T> Response<T> fail(String errorCode, String errorMessage) {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        response.setErrorCode(errorCode);
        response.setMessage(errorMessage);
        return response;
    }

    // 场景 D: ✨ 核心优化：直接传入枚举！
    // 用法: Response.fail(ResponseCodeEnum.LOGIN_FAIL);
    public static <T> Response<T> fail(ResponseCodeEnum responseCodeEnum) {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        response.setErrorCode(responseCodeEnum.getErrorCode());
        response.setMessage(responseCodeEnum.getErrorMessage());
        return response;
    }

    public static <T> Response<T> fail(BizException bizException) {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        response.setErrorCode(bizException.getErrorCode());
        response.setMessage(bizException.getErrorMessage());
        return response;
    }
}