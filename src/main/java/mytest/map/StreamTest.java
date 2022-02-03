package mytest.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {
//        List<Person> persons = Arrays.asList(
//                new Person("mkyong", 30),
//                new Person("jack", 20),
//                new Person("lawrence", 40)
//        );
//
//        Person result1 = persons.stream()
//                .filter(x -> "jack".equals(x.getName()))
//                .findAny()
//                .orElse(null);
//
//        System.out.println(result1);
//
//        Person result2 = persons.stream()
//                .filter(x -> "ahmook".equals(x.getName()))
//                .findAny()
//                .orElse(null);
//
//        System.out.println(result2);
//
//        List<Person> persons2 = persons.stream()
//                .filter(x -> !"jack".equals(x.getName()))
//                .collect(Collectors.toList());
//
//        System.out.println(persons2);

        Map<String, Person> personMap = new HashMap<>();

        Person mkyong = new Person("mkyong", 30);
        Person jack =new Person("jack", 20);
        Person lawrence =new Person("lawrence", 40);
        personMap.put(mkyong.getName(), mkyong);
        personMap.put(jack.getName(), jack);
        personMap.put(lawrence.getName(), lawrence);

        List<Person> personList = personMap.values().stream().collect(Collectors.toList());
        System.out.println(personList);

        List<Integer> numbers = Arrays.asList(new Integer(80),new Integer(19));
        List<Integer> evenNumbers7 = filter(numbers, (Integer i) -> i % 2 == 0);
        System.out.println(evenNumbers7);
    }

    private static List<Integer> filter(List<Integer> numbers, Predicate<Integer> p) {
        List<Integer> result = new ArrayList<>();
        for (Integer number: numbers) {
            if (p.test(number)) {
                result.add(number);
            }
        }

        return result;
    }

}


