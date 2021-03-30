package mytest.other;

class A {

}

class B extends A {

}

public class IsAssignFromTest {

    public static void main(String[] args) {

        A a = new A();
        B b = new B();
        A ba = new B();

        System.out.println(A.class.isAssignableFrom(B.class));
        System.out.println(B.class.isAssignableFrom(A.class));
        System.out.println("======================");

        System.out.println(a.getClass().isAssignableFrom(A.class));
        System.out.println(b.getClass().isAssignableFrom(B.class));
        System.out.println(ba.getClass().isAssignableFrom(A.class));
        System.out.println(ba.getClass().isAssignableFrom(B.class));
        System.out.println("======================");

        System.out.println(Object.class.isAssignableFrom(A.class));
        System.out.println(Object.class.isAssignableFrom(B.class));
        System.out.println(A.class.isAssignableFrom(Object.class));
        System.out.println(B.class.isAssignableFrom(Object.class));

    }
}
