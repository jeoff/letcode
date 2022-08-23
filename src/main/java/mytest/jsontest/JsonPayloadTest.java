package mytest.jsontest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class JsonPayloadTest {

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> payload = new HashMap<>();
        String[] str = new String[]{"zhangsan", "lisi"};
        payload.put("userid_list", str);

        System.out.println(mapper.writeValueAsString(payload));

    }
}
