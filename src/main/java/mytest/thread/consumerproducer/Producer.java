package mytest.thread.consumerproducer;

import lombok.extern.log4j.Log4j;

@Log4j
public class Producer extends Thread {
    private final Shared s;

    public Producer(Shared s) {
        this.s = s;
    }

    @Override
    public void run() {
        for (char c = 'A'; c <= 'Z'; c++) {
            synchronized (s) {
                try {
                    s.setSharedChar(c);
                    log.info(c + " produced");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
