package main.java.better;

public class ThreadJoin {

    public static void main(String[] args) {
        Thread t2 = new Thread(() -> {
            System.out.println("t2 strated");

            for (int i = 0; i < 4; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t2 end");
        });


        Thread t1 = new Thread(() -> {
            System.out.println("t1 started");

            try {
                t2.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (int i = 0; i < 2; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("t1 finished");
        });
        t1.start();
        t2.start();
    }
}
