package wiki.test;

import java.util.concurrent.*;

/**
 * Created by chen on 2020/4/29.
 */
public class FutureTaskTest {

    public Integer getData() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        CompletionService<Integer> completionService = new ExecutorCompletionService<>(executorService);

        Future<Integer> f1 = completionService.submit(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 34;
        });
        Future<Integer> f2 = completionService.submit(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 35;
        });
        Future<Integer> f3 = completionService.submit(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 40;
        });
        return f1.get()|f2.get()|f3.get();
    }
}
