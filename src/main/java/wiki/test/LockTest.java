package wiki.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock 可重入锁
 * Created by chen on 2020/4/23.
 */
public class LockTest {

    private static final Lock lock = new ReentrantLock();


    private static int value;

    public static void increase() {
        lock.lock();
        try {
            value++;
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Thread[] array = new Thread[20];
        for (int i = 0; i < 20; i++) {
            array[i]=new Thread(()->{
                for (int j = 0; j < 10000; j++) {
                    increase();
                }
            });
            array[i].start();
        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(value);
    }
}
