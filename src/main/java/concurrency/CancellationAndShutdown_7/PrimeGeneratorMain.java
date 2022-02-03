package concurrency.CancellationAndShutdown_7;

import java.math.BigInteger;
import java.util.List;

public class PrimeGeneratorMain {
    public static void main(String[] args) {
        PrimeGenerator generator = new PrimeGenerator();
        new Thread(generator).start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            generator.cancel();
        }
        List<BigInteger> ls = generator.get();
        for (int i = 0; i < ls.size(); i++) {
            System.out.println(ls.get(i));
        }
    }
}
