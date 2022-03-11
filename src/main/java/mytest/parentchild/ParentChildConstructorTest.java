package mytest.parentchild;

public class ParentChildConstructorTest {
    public static void main(String[] args) {
        //Father father = new Father();
        Father son = new Son();
    }
}

class Father {
    public Father() {
        System.out.println("Father");
    }
}

class Son extends Father {
    public Son() {
        System.out.println("Son");
    }
}
