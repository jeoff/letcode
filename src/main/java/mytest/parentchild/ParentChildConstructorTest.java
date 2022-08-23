package mytest.parentchild;

import mytest.parentchild.domain.Father;
import mytest.parentchild.domain.Son;

public class ParentChildConstructorTest {
    public static void main(String[] args) {
        //Father father = new Father();
        Father father = new Son();

//        Son son = new Father("Tom", "male", "test@baidu.com");
        Father f2 = new Father();
        f2.setName("parent f2");
        f2.setEmail("parent email");

        Son son = (Son) f2;
        System.out.println(son);
    }
}




