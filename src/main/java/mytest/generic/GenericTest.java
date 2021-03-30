package mytest.generic;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class GenericTest {

    public static void main(String[] args) {
        test1();
        test2();

        GenericTest test = new GenericTest();
        test.sortStringTest();

        test.testErasure();
    }

    public static void test1() {
        List<Integer> intList = new ArrayList<>();
        intList.add(new Integer(2));

        //compile error
        //List<Number> numList = intList;
    }

    public static void test2() {
        List<Number> intList = new ArrayList<>();
        intList.add(new Integer(2));

        //compile error
        intList.add(new Double(2.34));

        System.out.println(Arrays.asList(intList));
    }

    public void sortStringTest() {
        String[] strs = {"Orange", "Apple", "Pear"};

        Arrays.sort(strs);
        System.out.println(Arrays.asList(strs));


        Person[] ps = new Person[] {
                new Person("Bob", 61),
                new Person("Bob", 109),
                new Person("Alice", 88),
                new Person("Lily", 75),
                new Person("Lily", 99),
                new Person("Lily", 86)
        };

        Arrays.sort(ps);
        System.out.println(Arrays.asList(ps));

    }

    @Data
    @AllArgsConstructor
    class Person implements Comparable<Person> {
        String name;
        int age;

        @Override
        public int compareTo(Person person) {

            if (this.name.equals(person.name)) {
                return this.age - person.age;
            } else {
                return name.compareTo(person.name);
            }

        }
    }

    /**
     * type erasure
     * https://www.liaoxuefeng.com/wiki/1252599548343744/1265104600263968
     */
    @Data
    @AllArgsConstructor
    class Pair<T> {
        T first;
        T last;
    }

    public void testErasure() {
        Pair<String> pair = new Pair<>("first", "last");

        System.out.println(pair.toString());

        Pair<Double> doublePair = new Pair<>(3.14, 6.54);
        System.out.println(doublePair);
    }


}
