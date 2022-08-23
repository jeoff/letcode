package mytest.string;

public class StringLengthTest {

    public static void main(String[] args) {
        String test = "00D1s0000008asuEAA";
        int length = test.length();

        System.out.println(length == 15 || length == 18);
    }
}
