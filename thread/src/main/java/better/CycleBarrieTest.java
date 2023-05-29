package main.java.better;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CycleBarrieTest {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(30, () -> System.out.println("满人"));


        for (int i = 0; i < 100; i++) {
            new Thread(()-> {

                try {
                    Thread.sleep(100);
                    cyclicBarrier.await();
                    System.out.println("当前：");
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }
}
