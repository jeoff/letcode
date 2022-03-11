package mytest.map;

import lombok.extern.log4j.Log4j;

import java.util.HashMap;
import java.util.Map;

@Log4j
public class NullValueMapTest {

    public static void main(String[] args) {
        Map<String, String> testMap = new HashMap<>(16);

        testMap.put("key1_null", null);
        testMap.put("key2_null", null);
        testMap.put("key3", "value");

        testMap.keySet().forEach( key -> {
            log.info(key + " \t" +testMap.get(key));
        });

        log.info("key4 \t" + testMap.get("key4"));
        log.info("key5 \t" + testMap.getOrDefault("key5", "key5_default"));

    }
}
