package mytest.optional;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class NullOptionalTest {
    public static void main(String[] args) {
        List<String> newList = new ArrayList<>();
        newList.add("new");
        List<String> nullList = null;

        System.out.println(optionalTest(newList));
        System.out.println(Optional.ofNullable(nullList).map(list -> list.isEmpty()?null : list.get(0)));

        User user1 = new User(null, 11);
        User user2 = new User("", 30);
        User user3 = new User("zcf", 30);
        System.out.println(Optional.ofNullable(user1.getName()).orElse("testNull"));
        System.out.println(Optional.ofNullable(user2.getName()).orElse("testEmpty"));
        System.out.println(Optional.ofNullable(user3.getName()).orElse(""));

        User user4 = new User("", 20);
        user4.setStatus((byte) 122);
        System.out.println(user4);
        System.out.println(Optional.ofNullable(user4.getStatus()).map(Objects::toString).orElse(""));
        //System.out.println(Optional.ofNullable(user4.getName()).filter(Objects::nonNull).map(Objects::toString).orElse("user4-5"));

    }

    private static String optionalTest(List<String> newList){
        return Optional.ofNullable(newList).map(list -> list.isEmpty()? null : list.get(0)).orElse("");
    }
}

@Data
class User {
    private String name;
    private int age;
    private byte status;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
