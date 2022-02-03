package concurrency.CancellationAndShutdown_7;

import com.google.errorprone.annotations.concurrent.GuardedBy;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class PrimeGenerator implements Runnable {

    @GuardedBy("this")
    private final List<BigInteger> primes = new ArrayList<BigInteger>();

    private volatile boolean cancelled;

    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        while(!cancelled){
            //返回下一个大于p的素数
            p = p.nextProbablePrime();
            synchronized (this) {
                primes.add(p);

            }
        }
    }

    public void cancel(){
        cancelled = true;
    }

    public synchronized List<BigInteger> get(){
        return new ArrayList<BigInteger>(primes);
    }

}
