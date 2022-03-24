package mytest.parentchild;

import lombok.AllArgsConstructor;
import lombok.Data;

public class ParentChildConstructorTest {
    public static void main(String[] args) {
        //Father father = new Father();
        Father father = new Son();

//        Son son = new Father("Tom", "male", "test@baidu.com");
    }
}

@Data
@AllArgsConstructor
class Father {
    public Father() {
        System.out.println("Father");
    }

    String name;
    String gender;
    String email;
}

@Data
@AllArgsConstructor
class Son extends Father {
    public Son() {
        System.out.println("Son");
    }

    String childProperty;
}
