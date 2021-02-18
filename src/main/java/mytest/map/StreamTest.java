package mytest.map;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("mkyong", 30),
                new Person("jack", 20),
                new Person("lawrence", 40)
        );

        Person result1 = persons.stream()
                .filter(x -> "jack".equals(x.getName()))
                .findAny()
                .orElse(null);

        System.out.println(result1);

        Person result2 = persons.stream()
                .filter(x -> "ahmook".equals(x.getName()))
                .findAny()
                .orElse(null);

        System.out.println(result2);

        List<Person> persons2 = persons.stream()
                .filter(x -> !"jack".equals(x.getName()))
                .collect(Collectors.toList());

        System.out.println(persons2);
    }

}

@Data
@AllArgsConstructor
class Person {
    private String name;
    private int age;
}
