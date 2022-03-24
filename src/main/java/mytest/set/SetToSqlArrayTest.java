package mytest.set;

import java.util.HashSet;
import java.util.Set;

public class SetToSqlArrayTest {
    public static void main(String[] args) {
        Set<String> idSets = new HashSet<>();

        idSets.add("aaa");
        idSets.add("bbb");
        idSets.add("ccc");

        System.out.println(String.join("','",idSets));

        StringBuilder sbd = new StringBuilder();
        System.out.println(sbd.append("'").append(String.join("','", idSets)).append("'"));
    }
}
