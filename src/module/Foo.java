package module;

import java.util.concurrent.CountDownLatch;

public class Foo {

    private CountDownLatch afterFirst = new CountDownLatch(1);
    private CountDownLatch afterSecond = new CountDownLatch(1);

    public void first(Runnable r) throws InterruptedException {
        r.run();
        afterFirst.countDown();
    }
    public void second(Runnable r) throws InterruptedException{
        afterFirst.await();
        r.run();
        afterSecond.countDown();
    }
    public void third(Runnable r) throws InterruptedException {
        afterSecond.await();
        r.run();
    }
}
