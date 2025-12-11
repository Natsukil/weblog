package top.natsuki.weblog.web;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.natsuki.weblog.common.domain.dos.UserDO;
import top.natsuki.weblog.common.domain.mapper.UserMapper;

import java.util.Date;

/**
 * @author nat4u
 * @date 2025/12/10  19:55
 */
@SpringBootTest
@Slf4j
public class WeblogWebApplicationTests {

    @Test
    public void test() {
        // 编写单元测试
    }

    @Test
    void testLog() {
        log.trace("这是trace日志");
        log.debug("这是debug日志");
        log.info("这是info日志");
        log.warn("这是warn日志");
        log.error("这是error日志");
        // 占位符
        String author = "Natsuki";
        log.info("这是一行带有占位符日志，作者：{}", author);
    }

    @Autowired
    private UserMapper userMapper;

    @Test
    void insertTest() {
        // 构建数据库实体类
        UserDO userDO = UserDO.builder()
                .username("犬小哈")
                .password("123456")
                .createTime(new Date())
                .updateTime(new Date())
                .isDeleted(false)
                .build();

        userMapper.insert(userDO);
    }
}
