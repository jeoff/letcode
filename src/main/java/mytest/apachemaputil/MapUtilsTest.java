package mytest.apachemaputil;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.map.LinkedMap;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class MapUtilsTest {

    /**
     * debugPrint(PrintStream out, Object label, Map<?,?> map)
     * Prints the given map with nice line breaks.
     * {
     *     key1 = 1 java.lang.Byte
     *     key2 = 2 java.lang.Byte
     *     key3 = 3 java.lang.Byte
     * } java.util.TreeMap
     */
    @Test
    public void test1() {
        Map<String, Object> map = new TreeMap<>();
        map.put("key1", (byte) 1);
        map.put("key2", (byte) 2);
        map.put("key3", (byte) 3);
        MapUtils.debugPrint(System.out, null, map);
        /**
         * {
         *     key1 = 1 java.lang.Byte
         *     key2 = 2 java.lang.Byte
         *     key3 = 3 java.lang.Byte
         * } java.util.TreeMap
         */
    }

    /**
     * emptyIfNull(Map<K,V> map)
     * Returns an immutable empty map if the argument is null, or the argument itself otherwise.
     */
    @Test
    public void test2() {
        Map<String, String> map = new LinkedMap();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        Map<String, String> result = MapUtils.emptyIfNull(map);
        System.out.println("result = " + result); // result = {key1=value1, key2=value2, key3=value3}
    }

    /**
     * fixedSizeMap(Map<K,V> map)
     * Returns a fixed-sized map backed by the given map.
     */
    @Test
    public void test3() {
        Map<String, Object> map = new HashMap<>();
        map.put("key1", 1);
        map.put("key2", 2);
        map.put("key3", 3);
        IterableMap<String, Object> result = MapUtils.fixedSizeMap(map);
        System.out.println("result = " + result); // result = {key1=1, key2=2, key3=3}
        result.put("key3", 4);
        System.out.println("result = " + result); // result = {key1=1, key2=2, key3=4}

        result.put("key4", 5); // java.lang.IllegalArgumentException: Cannot put new key/value pair - Map is fixed size
    }

    /**
     * fixedSizeSortedMap(SortedMap<K,V> map)
     * Returns a fixed-sized sorted map backed by the given sorted map.
     */
    @Test
    public void test4() {
        SortedMap<String, Object> sortedMap = new TreeMap<>();
        sortedMap.put("name", "zhenghuixiang");
        sortedMap.put("age", "1");
        sortedMap.put("sex", "male");
        System.out.println("sortedMap = " + sortedMap);

        SortedMap<String, Object> result = MapUtils.fixedSizeSortedMap(sortedMap);
        // java.lang.IllegalArgumentException: Cannot put new key/value pair - Map is fixed size
        result.put("address", "Carton");
        System.out.println("result = " + result);
    }

    /**
     * getBoolean(Map<? super K,?> map, K key)
     * If the value is a Boolean it is returned directly.
     * If the value is a String and it equals 'true' ignoring case then true is returned, otherwise false.
     * If the value is a Number an integer zero value returns false and non-zero returns true.
     * Otherwise, null is returned.
     */
    @Test
    public void test5() {
        Map<String, Object> map = new HashMap<>();
        map.put("booleanValue1", true);
        map.put("booleanValue2", false);

        map.put("stringValue1", "true");
        map.put("stringValue2", "www");

        map.put("numberValue1", 1.1f);
        map.put("numberValue2", 0);

        boolean booleanValue1 = MapUtils.getBoolean(map, "booleanValue1");
        boolean booleanValue2 = MapUtils.getBoolean(map, "booleanValue2");

        boolean stringValue1 = MapUtils.getBoolean(map, "stringValue1");
        boolean stringValue2 = MapUtils.getBoolean(map, "stringValue2");

        boolean numberValue1 = MapUtils.getBoolean(map, "numberValue1");
        boolean numberValue2 = MapUtils.getBoolean(map, "numberValue2");

        String result = String.format("booleanValue1 = %b, " +
                        "booleanValue2 = %b, " +
                        "stringValue1 = %b, " +
                        "stringValue2 = %b, " +
                        "numberValue1 = %b, " +
                        "numberValue2 = %b",
                booleanValue1,
                booleanValue2,
                stringValue1,
                stringValue2,
                numberValue1,
                numberValue2);
        System.out.println("result = " + result); // result = booleanValue1 = true, booleanValue2 = false, stringValue1 = true, stringValue2 = false, numberValue1 = true, numberValue2 = false


        Boolean numberValue3 = MapUtils.getBoolean(map, "numberValue3");
        System.out.println("numberValue3 = " + numberValue3); // numberValue3 = null
    }

    /**
     * invertMap(Map<K,V> map)
     * Inverts the supplied map returning a new HashMap such that the keys of the input are swapped with the values.
     * 反转key - value 为 value - key
     */
    @Test
    public void test6() {
        Map<String, Object> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        System.out.println("map = " + map); // map = {key1=value1, key2=value2, key3=value3}
        Map<Object, String> result = MapUtils.invertMap(map);
        System.out.println("result = " + result); // result = {value2=key2, value1=key1, value3=key3}
    }

    /**
     * isEmpty(Map<?,?> map)
     * Null-safe check if the specified map is empty. Returns: true if empty or null
     * size为0或者null对象都返回true
     */
    @Test
    public void test7() {
        Map<String, Object> map = new HashMap<>();
        boolean isEmpty = MapUtils.isEmpty(map);
        System.out.println("isEmpty = " + isEmpty); // isEmpty = true

        isEmpty = MapUtils.isEmpty(null);
        System.out.println("isEmpty = " + isEmpty); // isEmpty = true
    }

    /**
     * iterableMap(Map<K,V> map)
     * Get the specified Map as an IterableMap.
     */
    @Test
    public void test8() {
        Map<String, Object> map = new TreeMap<>();
        map.put("name", "value1");
        map.put("age", "value2");
        map.put("sex", "value3");

        IterableMap<String, Object> result = MapUtils.iterableMap(map);
        MapIterator<String, Object> iterator = result.mapIterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            Object value = iterator.getValue();
            System.out.println(String.format("key = %s, value = %s", key, value));
            /**
             * key = age, value = value2
             * key = name, value = value1
             * key = sex, value = value3
             */
        }
    }

    /**
     * lazyMap(Map<K,V> map, Factory<? extends V> factory)
     * Returns a "lazy" map whose values will be created on demand.
     */
    @Test
    public void test9() {
        IterableMap<String, Object> result = MapUtils.lazyMap(new HashMap<>(), (Factory<Object>) Date::new);
        result.put("key1", "value1");
        result.put("key2", "value2");
        result.put("key3", "value3");
        Object value = result.get("key4");
        System.out.println("value = " + value); // value = Fri Sep 27 16:37:05 CST 2019
    }

    /**
     * orderedMap(Map<K,V> map)
     * Returns a map that maintains the order of keys that are added backed by the given map.
     * If a key is added twice, the order is determined by the first add. The order is observed through the keySet, values and entrySet.
     * 如果一个键被加入了多次，则以第一次key的位置为准，值依旧会替换
     */
    @Test
    public void test11() {
        OrderedMap<String, Object> result = MapUtils.orderedMap(new HashMap<>());
        result.put("name", "value1");
        result.put("age", "value2");
        result.put("sex", "value3");
        result.put("name", "ww");
        result.put("name", "ww1");
        System.out.println("result = " + result); // result = {name=ww1, age=value2, sex=value3}
    }

    /**
     * populateMap(Map<K,V> map, Iterable<? extends E> elements, Transformer<E,K> keyTransformer, Transformer<E,V> valueTransformer)
     * Populates a Map using the supplied Transformers to transform the elements into keys and values.
     * 把一个集合按指定的转换规则设置到map里
     */
    @Test
    public void test12() {
        List<String> names = new ArrayList<>();
        String[] arr = {"1", "2", "3", "4", "5"};
        CollectionUtils.addAll(names, arr);

        Map<String, Object> map = new HashMap<>();
        MapUtils.populateMap(map, names, e -> {
            String key = null;
            switch (e) {
                case "1":
                    key = "a";
                    break;
                case "2":
                    key = "b";
                    break;
                case "3":
                    key = "c";
                    break;
                case "4":
                    key = "d";
                    break;
                case "5":
                    key = "e";
                    break;
            }
            return key;
        }, Integer::parseInt);
        System.out.println("map = " + map); // map = {a=1, b=2, c=3, d=4, e=5}
    }

    /**
     * populateMap(Map<K,V> map, Iterable<? extends V> elements, Transformer<V,K> keyTransformer)
     * Populates a Map using the supplied Transformer to transform the elements into keys, using the unaltered element as the value in the Map.
     */
    @Test
    public void test13() {
        List<String> names = new ArrayList<>();
        String[] arr = {"1", "2", "3", "4", "5"};
        CollectionUtils.addAll(names, arr);

        Map<String, Object> map = new HashMap<>();
        MapUtils.populateMap(map, names, e -> "key" + e);
        System.out.println("map = " + map); // map = {key1=1, key2=2, key5=5, key3=3, key4=4}
    }
}
