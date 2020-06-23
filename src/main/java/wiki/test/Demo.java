package wiki.test;

import wiki.Practice;
import wiki.alg.array.QuickSort1;
import wiki.alg.sort.QuickSort;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class Demo {


    @Test
    public void func1() {
        QuickSort1 sortDemo = new QuickSort1();
        int[] n1 = new int[]{1, 3, 4, 9, 10, 2, 0, 10, 3};
        System.out.println(Arrays.toString(sortDemo.getLeastNumbers(n1,5)));
    }

    @Test
    public void func2() {
        Practice practice = new Practice();
//        System.out.println(practice.hasGroupsSizeX(new int[]{1,1,1,1,1,0,0,0}));
//        System.out.println(practice.gcd(5,3));

        System.out.println(practice.lastRemaining(5, 3));
    }

    @Test
    public void func3() {
//        NQueenProblem nQueenProblem = new NQueenProblem();
//        nQueenProblem.solveNQ();
        QuickSort quickSort = new QuickSort();
        int[] nums=new int[]{3,4,5,1,2,6,10,89,67,63};
        quickSort.Sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void func4() {

        String ss = "[\"1010100\",\"1010101\",\"1010102\",\"1010103\",\"1011100\",\"1011101\",\"1011102\",\"1011103\",\"1011104\",\"1011105\",\"1011106\",\"1014100\",\"1014101\",\"1014102\",\"1014103\",\"1014104\",\"1014105\",\"1014106\",\"1014107\",\"1015100\",\"1015101\",\"1013100\",\"1013101\",\"1013102\",\"1013103\",\"1013104\",\"1013105\",\"1013106\"]";
        System.out.println("");
    }

    volatile int a;
    @Test
    public void func5() throws InterruptedException {
        Practice practice = new Practice();
        Thread thread1 = new Thread(()->{
            a++;
        });
        Thread thread2=new Thread(()->{
            System.out.println("线程中："+a);
        });
        thread1.start();
        thread2.start();
        System.out.println("主线程中："+a);
    }

    @Test
    public void func6() {
        Thread thread = Thread.currentThread();
            while (true) {
                if (thread.isInterrupted()) {
                    break;
                }
                try {
                    Thread.sleep(200);
                    System.out.println("执行了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
    @Test
    public void func7() {
        String ss = "今天真的是个www.2u2u2u-com-好天www-2u2u2u-com-气，天天学习，好好www-2u2u2u-com-向上，加油！www-2u2u2u-com-";
        StringBuilder stringBuilder = new StringBuilder();
        StringBuffer buffer = new StringBuffer();
    }

    @Test
    public void func8() {
        Map<String, Object> map = new HashMap<>();
        map.put("aa", 123);
        map.put("bb", 321);
        map.forEach((key,value)->{
            System.out.println(key + ":" + value);
        });
    }
    @Test
    public void func9() {

        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(4,8,10, TimeUnit.SECONDS,new ArrayBlockingQueue<>(3));
    }

    @Test
    public void func10() {
        for (int i = 0; i < 100; i++) {
            System.out.println(ThreadLocalRandom.current().nextInt(0, 100));
        }

        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        condition.signalAll();

        Semaphore semaphore = new Semaphore(20);

        ReadWriteLock readWriteLock=new ReentrantReadWriteLock();

    }

    int k=0;
    @Test
    public void func11() throws Exception{
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Executor executor = Executors.newFixedThreadPool(2);
        Thread t1=new Thread(()->{
            k++;
            countDownLatch.countDown();
        });
        Thread t2 = new Thread(()->{
            k++;
            countDownLatch.countDown();
        });
        executor.execute(t1);
        executor.execute(t2);
        countDownLatch.await();
        System.out.println(k);
    }

    @Test
    public void func12() throws InterruptedException {
        Queue<Integer> a = new LinkedList<>();
        Queue<Integer> b = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            a.add(i);
            b.add(i);
        }

        CyclicBarrier barrier = new CyclicBarrier(2,()->{
            System.out.println(a.poll() + b.poll());
        });

        Thread t1=new Thread(()->{
            while (!a.isEmpty()) {
                try {
                    barrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2=new Thread(()->{
            while (!b.isEmpty()) {
                try {
                    barrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

}
