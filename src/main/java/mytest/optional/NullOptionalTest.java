package mytest.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NullOptionalTest {
    public static void main(String[] args) {
        List<String> newList = new ArrayList<>();
        newList.add("new");
        List<String> nullList = null;

        System.out.println(optionalTest(newList));
        System.out.println(Optional.ofNullable(nullList).map(list -> list.isEmpty()?null : list.get(0)));
    }

    private static String optionalTest(List<String> newList){
        return Optional.ofNullable(newList).map(list -> list.isEmpty()? null : list.get(0)).orElse("");
    }
}
