package wiki.test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Created by chen on 2020/4/30.
 */
public class Fibonacci extends RecursiveTask<Integer> {

    final int n;
    public Fibonacci(int n) {
        this.n=n;
    }
    @Override
    protected Integer compute() {
        if(n<=1) return n;
        Fibonacci f1 = new Fibonacci(n - 1);
        f1.fork();
        Fibonacci f2 = new Fibonacci(n - 2);
        return f1.join()+f2.compute();
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        Fibonacci fibonacci = new Fibonacci(30);
        Integer invoke = forkJoinPool.invoke(fibonacci);
        System.out.println(invoke);
    }
}
