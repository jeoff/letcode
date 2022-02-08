package mytest.thread.consumerproducer;

public class Shared {
    private char c;
    private volatile boolean writeable = true;

    public synchronized void setSharedChar(char val) throws InterruptedException {
        while(!writeable) {
            wait();
        }
        c = val;
        writeable = false;
        notify();
    }

    public synchronized char getSharedChar() throws InterruptedException {
        while(writeable) {
            wait();
        }
        writeable = true;
        notify();
        return c;
    }

}
