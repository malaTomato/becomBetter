package better;

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
            for (int i = 0; i < 1; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t2 join");
            try {
                t2.join();
            } catch (InterruptedException e) {
            }
            for (int i = 0; i < 4; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t2 finished");
        });
        t1.start();
        t2.start();
    }
}
