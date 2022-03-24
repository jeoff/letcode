package mytest.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class CollectionOrStreamForEachTest {
    public static void main(String[] args) {
        List<String> list = asList("A", "B", "C", "D", "E", "F", "G", "H");

        int count = 5;
        for (int i = 0; i < count; i++) {
            list.forEach(System.out::print);
            System.out.print(" ");
            list.parallelStream().forEach(System.out::print);
            System.out.print(" ");
            list.stream().forEach(System.out::print);
            System.out.println("");
        }

    }

    @Test
    public void givenTwoCollections_whenStreamedSequentially_thenCheckOutputDifferent() {
        List<String> list = Arrays.asList("B", "A", "C", "D", "F");
        Set<String> set = new TreeSet<>(list);

        Object[] listOutput = list.stream().toArray();
        Object[] setOutput = set.stream().toArray();

        assertEquals("[B, A, C, D, F]", Arrays.toString(listOutput));
        assertEquals("[A, B, C, D, F]", Arrays.toString(setOutput));
    }
}
