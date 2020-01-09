package mytest;

class Parent {

    public void method (){
        System.out.println("Base");
    }

}

class Child extends Parent
{
    @Override
    public void method() {
        System.out.println("Child");
    }

    public void methodB() {
        System.out.println("MehtodB");
    }
}



public class ParentChildTest {
    public static void main(String[] args) {
        Parent test = new Child();
        test.method();
    }
}
