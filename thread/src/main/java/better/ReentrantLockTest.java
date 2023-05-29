package main.java.better;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    //    static ReentrantLock lock = new ReentrantLock();
    ReentrantLock lock = new ReentrantLock(true);// 公平锁


    void run() {
        for (int i = 0; i < 100; i++) {
            try {
                lock.lock();
//            lock.lockInterruptibly(); 可打断锁
                System.out.println(Thread.currentThread().getName());
//                System.out.println(lock.isLocked());
            } finally {
                lock.unlock();
//                System.out.println(lock.isLocked());
            }
        }
    }

    public static void main(String[] args) {

        ReentrantLockTest reentrantLockTest = new ReentrantLockTest();
        new Thread(reentrantLockTest::run, "thred1").start();
        new Thread(reentrantLockTest::run, "thred2").start();
    }
}
