package mytest.thread;


public class AtomicLongTest {
    public static AddCount count = new AddCount();

    public static void main(String[] args) {

        for(int i = 0; i <100; i++ ) {

            Thread thread = new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(100);
                        count.addOne();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };

            thread.run();

        }

        System.out.println(count.getCount());

    }

}


class AddCount {
    private int count;
    public void addOne() {
        ++count;
    }
    public int getCount() {
        return count;
    }
}
