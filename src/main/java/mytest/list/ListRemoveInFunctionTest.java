package mytest.list;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class ListRemoveInFunctionTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        System.out.println(list);

        removeListMember(list);
        System.out.println(list);
    }

    public static void removeListMember(List<String> list) {
        list.removeAll(asList("C", "A"));
    }
}
