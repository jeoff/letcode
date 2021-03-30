package mytest.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.extern.log4j.Log4j;

@Log4j
public class GuavaCacheTest {
    public static void main(String[] args) {

        Cache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(3)
                .recordStats()
                .build();


        cache.put("1", "v1");
        cache.put("2", "v2");
        cache.put("3", "v3");
        cache.put("4", "v4");

        cache.getIfPresent("1");
        cache.getIfPresent("2");
        cache.getIfPresent("3");
        cache.getIfPresent("4");
        cache.getIfPresent("5");
        cache.getIfPresent("6");

        log.info(cache.stats());


    }
}
