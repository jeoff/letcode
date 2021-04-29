package mytest.string;

public class CharTest {
    public static void main(String[] args) {
        for (int i = 'a'; i < 'z'; i++) {
            System.out.println(i);
        }

        for (int j = 0; j < 1000; j++) {
            System.out.println(j + " " + (char)j);
        }
    }
}
