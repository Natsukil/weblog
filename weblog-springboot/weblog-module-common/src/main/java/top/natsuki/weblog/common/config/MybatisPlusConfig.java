package top.natsuki.weblog.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan("top.natsuki.weblog.common.domain.mapper")
public class MybatisPlusConfig {
}