package MyTest.BigDecimal;

import java.math.BigDecimal;

public class BigDecimalTest {

    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("1.22");
        BigDecimal b = new BigDecimal("2.22");

        BigDecimal c = a.add(b);
        // a will not change
        System.out.println("a " + a);
        // BigDecimal都是不可变的，在进行每一步运算时，都会产生一个新的对象，所以在做加减乘除运算时千万要保存操作后的值。
        System.out.println("c " + c);
    }
}
