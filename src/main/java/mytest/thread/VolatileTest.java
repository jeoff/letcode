package mytest.thread;

import lombok.SneakyThrows;

public class VolatileTest {

    public static volatile int signal = 0;
    public static int round = 10;
    public static int step = 3;
    public static int total = round * step;

    static class ThreadA implements Runnable {
        @Override
        public void run() {
            while (signal < total) {
                if (signal % 3 == 0) {
                    System.out.println("Thread " + Thread.currentThread().getName() + " execute.");

                    synchronized (this) {
                        signal++;
                    }
                }
            }
        }
    }

    static class ThreadB implements Runnable {
        @Override
        public void run() {
            while (signal < total) {
                if (signal % 3 == 1) {
                    System.out.println("Thread " + Thread.currentThread().getName() + " execute.");

                    synchronized (this) {
                        signal = signal + 1;
                    }
                }
            }
        }
    }

    static class ThreadC implements Runnable {
        @Override
        public void run() {
            while (signal < total) {
                if (signal % 3 == 2) {
                    System.out.println("Thread " + Thread.currentThread().getName() + " execute.");

                    synchronized (this) {
                        signal++;
                    }
                }
            }
        }
    }


    @SneakyThrows
    public static void main(String[] args) {
        new Thread(new ThreadA(), "ThreadA").start();
        new Thread(new ThreadB(), "ThreadB").start();
        new Thread(new ThreadC(), "ThreadC").start();
    }
}
