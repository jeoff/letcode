package mytest.lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class LombokDefaultTest {
    public static void main(String[] args) {
        People p1 = new People();
        System.out.println(p1); //People(old=false)
        People p2 = People.builder().build(); //People(old=true)
        System.out.println(p2);
    }
}


@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
class People {
    @Builder.Default
    private boolean old = true;

    private String name;
    private int age;
}
