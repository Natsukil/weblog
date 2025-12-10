package top.natsuki.weblog.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.natsuki.weblog.common.aspect.ApiOperationLog;
import top.natsuki.weblog.common.enums.ResponseCodeEnum;
import top.natsuki.weblog.common.exception.BizException;
import top.natsuki.weblog.common.utils.JsonUtil;
import top.natsuki.weblog.common.utils.Response;
import top.natsuki.weblog.web.model.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.stream.Collectors;

/**
 * @author nat4u
 * @date 2025/12/10  21:07
 */
@RestController
@Slf4j
@Api(tags = "首页模块")
public class TestController {

    @PostMapping("/test")
    @ApiOperationLog(description = "测试接口")
    @ApiOperation(value = "测试接口", notes = "测试接口")
    public Response test(@RequestBody @Validated User user, BindingResult bindingResult){
        // 手动抛异常，入参是前面定义好的异常码枚举，返参统一交给全局异常处理器搞定
//        throw new BizException(ResponseCodeEnum.PRODUCT_NOT_FOUND);
//        if (bindingResult.hasErrors()) {
//            // 输出错误信息
//            String errorMessage = bindingResult.getFieldErrors()
//                    .stream()
//                    .map(FieldError::getDefaultMessage)
//                    .collect(Collectors.joining(", "));
//
//            return Response.fail(errorMessage);
//        }
//
//        // 返参
//        return Response.success();
        // 打印入参
        log.info(JsonUtil.toJsonString(user));

        // 设置三种日期字段值
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateDate(LocalDate.now());
        user.setTime(LocalTime.now());

        return Response.success(user);
    }

}
