package mytest.lambda;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ChainingConstructorTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>(Arrays.asList("Tom", "Jerry", "Harry"));

        Map<String, User> userMap = set.stream().filter(Objects::nonNull).filter(StringUtils::isNotBlank)
                .map(User::new)
                .collect(Collectors.toMap(User::getName, Function.identity()));

        System.out.println(userMap);
    }
}

@Data
class User {
    User(String name) {
        this.name = name;
    }

    String name;
    String email;
    int age;
    String gender;
}
