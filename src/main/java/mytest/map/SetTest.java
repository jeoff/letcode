package mytest.map;

import lombok.extern.log4j.Log4j;

import java.util.HashSet;
import java.util.Set;

@Log4j
public class SetTest {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        //check add multiple time no exception
        set.add("1");
        set.add("2");
        set.add("1");
        log.info(set);
    }
}
