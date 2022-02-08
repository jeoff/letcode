package mytest.thread.consumerproducer;

public class ProducerComsumerTest {
    public static void main(String[] args) {
        Shared c = new Shared();

        new Producer(c).start();
        new Consumer(c).start();
    }
}
