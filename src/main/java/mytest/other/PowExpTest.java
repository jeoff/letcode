package mytest.other;

import java.util.Scanner;

public class PowExpTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please give base:");
        double base = sc.nextDouble();

        System.out.println("Please give exp:");
        int exp = sc.nextInt();

        double result = PowExpTest.pow(base, exp);
        System.out.println(result);

    }

    public static double pow(double base, int exp) {
        //x^0 = 1
        double result = 1;
        for(int i = 0; i < exp; i++) {
            result *= base;
        }

        return result;
    }

}
