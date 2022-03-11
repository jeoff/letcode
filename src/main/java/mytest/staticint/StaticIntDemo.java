package mytest.staticint;

public class StaticIntDemo {
    public static int a = 1;

    public static void main(String[] args) {
        int a = 11;
        a++;
        StaticIntDemo.a++;

        StaticIntDemo test = new StaticIntDemo();
        System.out.println("a=" + a + "; static a=" + test.a);
    }
}
