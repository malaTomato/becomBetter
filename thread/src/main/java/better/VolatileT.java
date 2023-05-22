package main.java.better;

public class VolatileT {

    private static volatile VolatileT INSTANCE = null;

    private VolatileT() {

    }

    /**
     * DLC   双重检查单例
     * 加上volatile 禁止指令重排序
     * @return
     * @throws InterruptedException
     */
    public static VolatileT init() throws InterruptedException {
        if (INSTANCE == null) {
            synchronized (VolatileT.class) {
                if (INSTANCE == null) {
                    Thread.sleep(100);
                    INSTANCE = new VolatileT();
                    System.out.println("init success");
                }

            }
        }

        return INSTANCE;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {

                try {
                    System.out.println(init().hashCode());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }).start();
        }
    }
}
