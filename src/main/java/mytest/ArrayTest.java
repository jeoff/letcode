package mytest;

import java.util.Arrays;
import java.util.List;

public class ArrayTest {

    private static final List<Integer> validDisclaimerSetting = Arrays.asList(1,2);

    public static void main(String[] args) {
        System.out.println(validDisclaimerSetting.contains(Integer.valueOf(1)));
        System.out.println(!validDisclaimerSetting.contains(1));
        System.out.println(!validDisclaimerSetting.contains(0));

        List nvlList = null;
        System.out.println(nvlList == null? 0: nvlList.size());
    }
}
