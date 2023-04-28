package org.bear;

/**
 * [becomBetter]
 * [org.bear]
 * [2023/04/28 17:14]
 *
 * @author [willson.xiong]
 * @version 1.0.0
 */
public class CpuSoaring {
    public static void main(String[] args) {


        Thread thread1 = new Thread(new Runnable() {

            public void run() {
                for (;;){
                    System.out.println("thread 1");
                }
            }
        },"thread 1");


        Thread thread2 = new Thread(new Runnable() {

            public void run() {
                for (;;){
                    System.out.println("thread 2");
                }
            }
        },"thread 2");


        thread1.start();
        thread2.start();

        System.out.println("main");

    }
}
