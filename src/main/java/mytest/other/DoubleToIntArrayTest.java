package mytest.other;

import java.util.Arrays;

public class DoubleToIntArrayTest {

    public static void main(String[] args) {
        double pi = 3.1415;

        //method 1
        int[] piArray = Double.toString(pi)
                .replaceAll("\\D","")
                .chars()
                .map(Character::getNumericValue)
                .toArray();
        System.out.println(Arrays.toString(piArray));



    }
}
