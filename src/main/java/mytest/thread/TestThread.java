package mytest.thread;

public class TestThread {
    public static void main(String[] args) {
        new MyThread().start();
    }
}
class MyThread extends Thread {
    int total;
    @Override
    public void run() {
        synchronized (this) {
            System.out.println("MyThread is running..");
            for (int i = 0; i < 10; i++) {
                total += i;
                System.out.println("total is " + total);
            }
            //notify();// 因为synchronized (this)，为了保证其他线程有wait可以被重新唤醒
        }
    }
}
