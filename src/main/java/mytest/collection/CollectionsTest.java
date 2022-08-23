package mytest.collection;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.ListUtils;

import java.util.Collections;
import java.util.List;

public class CollectionsTest {
    public static void main(String[] args) {
        System.out.println(Collections.EMPTY_LIST);

        // Given
        List<Integer> intList = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);
        List<List<Integer>> subSets = ListUtils.partition(intList, 3);

        // When
        intList.add(9);
        intList.add(10);

        List<Integer> lastPartition = subSets.get(2);
        List<Integer> expectedLastPartition = Lists.<Integer> newArrayList(7, 8);
        System.out.println(subSets.size());
        System.out.println(lastPartition);
    }
}
