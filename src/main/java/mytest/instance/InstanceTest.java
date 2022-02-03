package mytest.instance;

public class InstanceTest {

    public static void main(String[] args) {

        Parent childOne = new ChildOne();
        Parent childTwo = new ChildTwo();

        System.out.println(childOne instanceof Parent);
        System.out.println(childOne instanceof ChildOne);
        System.out.println(childOne instanceof ChildTwo);

        System.out.println(childTwo instanceof Parent);
        System.out.println(childTwo instanceof ChildOne);
        System.out.println(childTwo instanceof ChildTwo);
    }
}
