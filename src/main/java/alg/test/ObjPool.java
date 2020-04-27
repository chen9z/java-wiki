package alg.test;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.function.Function;

/**
 * 对象池
 * @param <T>
 * @param <R>
 */
public class ObjPool<T, R> {
    final List<T> pool;

    final Semaphore semaphore;

    public ObjPool(int size, T t) {
        pool = new Vector<>(size);
        for (int i = 0; i < size; i++) {
            pool.add(t);
        }
        semaphore = new Semaphore(size);
    }

    R exec(Function<T, R> func) {
        T t=null;
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t = pool.remove(0);
            return func.apply(t);
        }finally {
            pool.add(t);
            semaphore.release();
        }
    }
}
