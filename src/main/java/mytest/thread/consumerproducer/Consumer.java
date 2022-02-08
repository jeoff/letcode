package mytest.thread.consumerproducer;

import lombok.extern.log4j.Log4j;

@Log4j
public class Consumer extends Thread {
    private final Shared s;

    public Consumer(Shared value) {
        this.s = value;
    }

    @Override
    public void run() {
        try {
            char ch;
            do {
                synchronized (s) {
                    ch = s.getSharedChar();
                    log.info(ch + " consumed.");
                }
            } while (ch != 'Z');
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
