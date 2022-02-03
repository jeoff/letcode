package mytest.thread;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    static Semaphore semaphore = new Semaphore(2);

    public static void main(String[] args) throws InterruptedException {

        for (int i=0; i<6; i++) {
            ConcurrentMapTest concurrentMapTest = new ConcurrentMapTest();
            concurrentMapTest.setName("zcf thread" + i);
            concurrentMapTest.start();
        }
        System.out.println(semaphore.availablePermits());

    }

    static class ConcurrentMapTest extends Thread {
        @Override
        public void run() {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "start");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "end");
            semaphore.release();

        }
    }

}


