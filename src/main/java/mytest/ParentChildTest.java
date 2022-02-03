package mytest;

import org.apache.commons.lang3.StringUtils;

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

        String nullTest = (String) null;
        System.out.println(nullTest);
        System.out.println(StringUtils.isBlank(nullTest));
        System.out.println(StringUtils.isEmpty(nullTest));
    }
}
