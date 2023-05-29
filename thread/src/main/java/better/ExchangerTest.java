package main.java.better;

import java.util.concurrent.Exchanger;

public class ExchangerTest {

    public static void main(String[] args) {

        Exchanger<String> exchanger = new Exchanger<>();

        new Thread(() -> {
            String t1 = "t1";
            try {
                t1 = exchanger.exchange(t1);
                System.out.println("t1:" + t1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            String t2 = "t2";
            try {
                Thread.sleep(2000L);//t1线程会等待t2开始交换时，继续执行
                t2 = exchanger.exchange(t2);
                System.out.println("t2:" + t2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

    }
}
