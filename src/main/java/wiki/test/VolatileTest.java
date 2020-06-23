package wiki.test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by chen on 2020/4/10.
 */
public class VolatileTest {

    public volatile static AtomicInteger race=new AtomicInteger();

    public static void increase() {
        race.getAndIncrement();
    }
    public static final int THREADS_COUNT=20;

    public static void main(String[] args) {
        Thread[] array = new Thread[20];
        for (int i = 0; i < THREADS_COUNT; i++) {
            array[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        increase();
                    }
                }
            }
            );
            array[i].start();
        }
        //等待所有累计线程结束
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(race);
    }
}
