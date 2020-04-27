import alg.Practice;
import alg.sort.QuickSort;
import alg.sort.SortDemo;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class Demo {


    @Test
    public void func1() {
        QuickSort sortDemo = new QuickSort();
        int[] n1 = new int[]{1, 3, 4, 9, 10, 2, 0, 10, 3};
        System.out.println(Arrays.toString(sortDemo.mergeSort(n1)));
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
}
