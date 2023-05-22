package main.java.better;

public class Sync {

    private Integer count = 0;

    public synchronized void modify() {
        this.count = count + 1;
        System.out.println(this.count);
    }

    public static void main(String[] args) throws InterruptedException {
        Sync sync = new Sync();
        for (int i = 0; i < 100; i++) {
            new Thread(sync::modify, "t"+i).start();

        }

        Thread.sleep(1000);
        System.out.println("end:"+sync.count);
    }
}
