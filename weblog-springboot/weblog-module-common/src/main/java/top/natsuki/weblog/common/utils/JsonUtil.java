package top.natsuki.weblog.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

/**
 * @author nat4u
 * @date 2025/12/10  20:34
 */
@Slf4j
public class JsonUtil {
    public static final ObjectMapper INSTANCE = new ObjectMapper();

    public static String toJsonString(Object obj){
        try{
            return INSTANCE.writeValueAsString(obj);
        }catch (JsonProcessingException e){
            log.error("json转换失败: {}", obj, e);
            return obj.toString();

        }
    }
}
