package mytest.thread;

import lombok.extern.log4j.Log4j;

public class SequencePrintTest {
    public static void main(String[] args) {
        Foo foo = new Foo();

        foo.printA();
        foo.printB();
    }
}

@Log4j
class Foo {
    void printA() {
        log.info("methodA");
    }

    void printB() {
        log.info("methodB");
    }

    void printC() {
        log.info("methodC");
    }
}
