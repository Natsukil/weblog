package top.natsuki.weblog.common.aspect;

import java.lang.annotation.*;

/**
 * @author nat4u
 * @date 2025/12/10  20:31
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface ApiOperationLog {
    /**
     * API 功能描述
     *
     * @return
     */
    String description() default "";
}
