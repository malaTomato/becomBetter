package main.java.better;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger();

        for (int i = 0; i < 100; i++) {
            new Thread(() -> atomicInteger.incrementAndGet()).start();
        }
        Thread.sleep(2000);

        System.out.println(atomicInteger.get());
    }


}
