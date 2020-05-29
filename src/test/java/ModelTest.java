import alg.Practice;
import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ModelTest {

    @Test
    public void func1() {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

    }

//    @Test
//    public void func2() {
//        Practice practice = new Practice();
//        System.out.println(practice.longestCommonPrefix(new String[]{""}));
//    }

}
