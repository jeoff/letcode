package mytest.parentchild;

public class ParentChildMethodTest {

    public static void main(String[] args) {
        Parent child = new Child();
    }
}

class Parent {
    private String str = "Father";

    public Parent() {
        callMe();
    }

    private void callMe() {
        System.out.println(str);
    }
}

class Child extends Parent {
    private String str = "Child";

    private void callMe() {
        System.out.println(str);
    }
}
