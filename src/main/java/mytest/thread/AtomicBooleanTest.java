package mytest.thread;

import lombok.extern.log4j.Log4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

@Log4j
public class AtomicBooleanTest {

    public static void main(String[] args) {
        Worker worker1 = new Worker("thread1");
        Worker worker2 = new Worker("thread2");

        new Thread(worker1, "threadName1").start();
        new Thread(worker2, "threadName2").start();
    }
}

@Log4j
class Worker implements Runnable {

    private static final AtomicBoolean exits = new AtomicBoolean(false);

    private String name;

    public Worker(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        log.info(this.name + " enter");

        while (!exits.getAndSet(true)) {
            sleep(this.name, 2);

            log.info(this.name + " execute");

            sleep(this.name, 1);

            log.info(this.name + " end");
        }
    }

    private final static void sleep(String name, long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
