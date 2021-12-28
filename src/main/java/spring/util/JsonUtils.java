package spring.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * JSON工具类
 */
@Slf4j
public class JsonUtils {

    private static final String EMPTY_STRING = "";
    private static final ObjectMapper OBJECTMAPPER = createObjectMapper();

    private static ObjectMapper createObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        //反序列化的时候如果多了其他属性,不抛出异常
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    }

    public static String toJSONString(Object object) {
        if (object == null) {
            return null;
        }
        try {
            return OBJECTMAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("实体转为json字符串异常", e);
        }
    }

    public static <T> T parseObject(String source, Class<T> clazz) {
        if (source == null) {
            return null;
        }
        try {
            return OBJECTMAPPER.readValue(source, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("json字符串转为实体类异常", e);
        }
    }

    public static <T> List<T> parseArray(String source, Class<T> clazz) {
        JavaType javaType = OBJECTMAPPER.getTypeFactory().constructParametricType(List.class, clazz);
        try {
            return OBJECTMAPPER.readValue(source, javaType);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("json字符串转为实体类列表异常", e);
        }
    }

    public static Map<String, Object> parseMap(String source) {
        try {
            return OBJECTMAPPER.readValue(source, new TypeReference<Map<String, Object>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException("json字符串转为map异常");
        }
    }

    public static String toJSONStringOrEmpty(Object object) {
        if (object == null) {
            return EMPTY_STRING;
        }
        try {
            return OBJECTMAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            return EMPTY_STRING;
        }
    }

    public static String toJSONStringOrDefault(Object object, String def) {
        if (object == null) {
            return def;
        }
        try {
            return OBJECTMAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            return def;
        }
    }

    public static ObjectMapper getObjectMapper() {
        return OBJECTMAPPER;
    }

    public static JsonNode readTree(String content) {
        try {
            return OBJECTMAPPER.readTree(content);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("字符串转为JsonNode异常");

        }
    }
}
