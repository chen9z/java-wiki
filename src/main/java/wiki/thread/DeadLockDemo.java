package wiki.thread;

/**
 * 死锁检查
 * Created by chen on 2020/7/24.
 */
public class DeadLockDemo extends Thread{

    private String first;
    private String second;

    public DeadLockDemo(String name, String first, String second) {
        super(name);
        this.first=first;
        this.second=second;
    }

    @Override
    public void run() {
        synchronized (first) {
            System.out.println(this.getName() + " obtained: " + first);
                try {
                    Thread.sleep(1000L);
                    synchronized (second) {
                        System.out.println(this.getName()+ " obtained: "+second);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }

    public static void main(String[] args) throws Exception{
        String lockA = "lockA";
        String lockB = "lockB";
        DeadLockDemo demo1 = new DeadLockDemo("thread1", lockA, lockB);
        DeadLockDemo demo2 = new DeadLockDemo("thread2", lockB, lockA);

        demo1.start();
        demo2.start();
        demo1.join();
        demo2.join();
    }

}
