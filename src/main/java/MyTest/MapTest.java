package mytest;

import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MapTest {

    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put( "key1", 1);

        Map<String,Integer> mapFirst = map;
        //System.out.println(mapFirst);

        Map<String, Integer> immutableMap = ImmutableMap.copyOf(map);
        Map<String, Integer> copyMap = new HashMap<>();
        copyMap.putAll(map);
        copyMap.put("key4", 4);

        map.put( "key2", 2);
        //immutableMap.put("key3", 3);

        System.out.println("mapFirst" + mapFirst);
        System.out.println("map" + map);
        System.out.println("immutableMap " + immutableMap);
        System.out.println("copyMap" + copyMap);

        System.out.println("key6" + map.get("key6"));

        System.out.println(UUID.randomUUID().toString());

    }

}
