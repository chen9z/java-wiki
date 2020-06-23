package wiki.test;

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

        for (int i = 0; i < 100; i++) {
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
        System.out.println((System.currentTimeMillis() - start) / 1000);
    }

    @Test
    public void func5() {
        CompletableFuture<String> stringCompletableFuture =
                CompletableFuture.supplyAsync(() -> "hello first")
                        .thenApply(s -> s + " second")
                        .thenApply(s -> s + " third");
        System.out.println(stringCompletableFuture.join());
    }

    @Test
    public void func6() {
        CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(() -> {
            int t = ThreadLocalRandom.current().nextInt(5, 10);
            try {
                Thread.sleep(t * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return t;
        });

        CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(() -> {
            int t = ThreadLocalRandom.current().nextInt(5, 9);
            try {
                Thread.sleep(t * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return t;
        });

        CompletableFuture<Integer> f3 = f1.applyToEither(f2, s -> s);
        System.out.println(f3.join());
    }

    @Test
    public void func7() {
        CompletableFuture<Boolean> f =
                CompletableFuture.supplyAsync(() -> 7 / 1).thenApply(a -> 7 == 7).exceptionally(e -> false);
        System.out.println(f.join());
    }

    @Test
    public void func8() {
        CompletableFuture<Void> f1 = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("烧好水了");
        });

        CompletableFuture<Void> f2 = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("洗好碗了");
        });
//        CompletableFuture<String> f3 = f1.thenCombine(f2, (__, tf) -> {
//            System.out.println("烧好茶了");
//            return "烧好茶了";
//        });
//        System.out.println(f3.join());
        CompletableFuture<Void> f3 = f1.runAfterBoth(f2, () -> {
            System.out.println("烧茶了");
        });
        f3.join();
    }

    @Test
    public void func9() throws InterruptedException {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.submit(() -> {
            try {
                Thread.sleep(2000);
                queue.put(34);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.submit(() -> {
            try {
                Thread.sleep(3000);
                queue.put(39);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.submit(() -> {
            try {
                Thread.sleep(1000);
                queue.put(45);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        for (int i = 0; i < 3; i++) {
            System.out.println(queue.take());
        }
    }

    @Test
    public void func10() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        CompletionService<Integer> completionService = new ExecutorCompletionService<>(executorService);

        completionService.submit(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 34;
        });
        completionService.submit(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 35;
        });
        completionService.submit(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 40;
        });
        CountDownLatch countDownLatch = new CountDownLatch(3);
        AtomicInteger atomicInteger = new AtomicInteger(Integer.MAX_VALUE);
        for (int i = 0; i < 3; i++) {
            Integer newValue = completionService.take().get();
            executorService.submit(()->{
                try {
                    atomicInteger.getAndUpdate(operand -> Math.min(operand,newValue));
                    countDownLatch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            });
        }
        countDownLatch.await();
        System.out.println(atomicInteger.get());
    }

    @Test
    public void func11() throws Exception{
        FutureTaskTest futureTaskTest = new FutureTaskTest();
        System.out.println(futureTaskTest.getData());
    }

    @Test
    public void func12() {
    }

}
