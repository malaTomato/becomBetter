package main.java.better;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriterLockTest {
    static Integer count;
    static Lock lock = new ReentrantLock();
    static ReadWriteLock readWriterLock = new ReentrantReadWriteLock();
    static Lock readLock = readWriterLock.readLock();
    static Lock writeLock = readWriterLock.writeLock();

    static void write(Lock lock, Integer integer) {
        try {
            lock.lock();
            Thread.sleep(100);
            System.out.println("write");
            count = integer;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    static Integer read(Lock lock) {

        try {
            lock.lock();
            Thread.sleep(100);
            System.out.println("read");
            return count;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
//            new Thread(() -> read(lock)).start();
            new Thread(() -> read(readLock)).start();
        }


        for (int i = 0; i < 2; i++) {
//            new Thread(() -> write(lock, new Random(2l).nextInt())).start();
            new Thread(() -> write(writeLock, new Random(2l).nextInt())).start();
        }

    }
}
