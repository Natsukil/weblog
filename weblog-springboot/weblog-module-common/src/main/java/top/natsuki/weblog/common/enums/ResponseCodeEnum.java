package top.natsuki.weblog.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import top.natsuki.weblog.common.exception.BaseExceptionInterface;

/**
 * 响应状态码枚举
 * 统一管理错误码，避免代码中出现魔术值
 */
@Getter
@AllArgsConstructor
public enum ResponseCodeEnum implements BaseExceptionInterface {

    // =========== 通用状态码 ===========
    SUCCESS("200", "操作成功"),
    FAIL("500", "服务器内部错误"),

    // =========== 业务状态码 (按模块划分) ===========
    PARAM_ERROR("400", "参数错误"),
    UNAUTHORIZED("401", "未登录或Token失效"),
    FORBIDDEN("403", "无权限访问"),
    NOT_FOUND("404", "资源不存在"),

    // 比如：用户模块 100xx
    USERNAME_EXIST("10001", "用户名已存在"),
    LOGIN_FAIL("10002", "用户名或密码错误"),


    SYSTEM_ERROR("10000", "出错啦，后台小哥正在努力修复中..."),
    PARAM_NOT_VALID("10003", "参数校验失败"),

    // ----------- 业务异常状态码 -----------
    PRODUCT_NOT_FOUND("20000", "该产品不存在（测试使用）"),
    ;

    private final String errorCode;
    private final String errorMessage;
}