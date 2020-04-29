import org.junit.Test;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by chen on 2020/4/28.
 */
public class ThreadTest {
    @Test
    public void func1() {

        List list = Collections.synchronizedList(new ArrayList<>());
        Set set = Collections.synchronizedSet(new HashSet<>());

        AtomicInteger atomicInteger = new AtomicInteger();
    }

    @Test
    public void func2() {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 10, 300, TimeUnit.SECONDS, new ArrayBlockingQueue<>(200), new ThreadFactory() {
            private final AtomicInteger atomicInteger = new AtomicInteger();

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "custom-thread-" + atomicInteger.incrementAndGet());
            }
        });

        for (int i = 0; i <100; i++) {
            poolExecutor.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":执行了");
            });
        }

        while (poolExecutor.getActiveCount() > 0) {
            Thread.yield();
        }
    }

    @Test
    public void func3() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        String s = "";
        FutureTask<String> stringFutureTask = new FutureTask<>(() -> "123");
        executorService.submit(stringFutureTask);
        System.out.println(stringFutureTask.get());
    }

    @Test
    public void func4() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        FutureTask<Integer> ft1 = new FutureTask<>(() -> {
            Thread.sleep(1000);
            return 34;
        });
        Thread t1 = new Thread(ft1);
        t1.start();

        FutureTask<Integer> ft2 = new FutureTask<>(() -> {
            Thread.sleep(5000);
            return 35;
        });
        Thread t2 = new Thread(ft2);
        t2.start();

        FutureTask<Integer> ft3 = new FutureTask<>(() -> {
            Thread.sleep(3000);
            return 30;
        });

        Thread t3 = new Thread(ft3);
        t3.start();


        Integer res = Integer.MAX_VALUE;
//        while (ft1.get() != null && ft2.get() != null && ft3.get() != null) {
            res = Math.min(res, ft1.get());
            res = Math.min(res, ft2.get());
            res = Math.min(res, ft3.get());
//        }
        System.out.println(res);
        System.out.println((System.currentTimeMillis()-start)/1000);
    }
}
