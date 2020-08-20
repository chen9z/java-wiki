package wiki.thread;

/**
 * Created by chen on 2020/7/23.
 */
public class ThreadTest {
    public static void main(String[] args) {
        hello();
        Thread.getAllStackTraces().forEach((thread, stackTraceElements) -> System.out.println(thread.getName()));
    }

    public static void hello() {
        System.out.println("hello world");
    }

}
