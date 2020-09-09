import jdk.dynalink.linker.LinkerServices;
import org.junit.Test;

import java.nio.charset.IllegalCharsetNameException;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by chen on 2020/8/21.
 */
public class Demo {

    @Test
    public void func() {
        int[] sort = new int[]{5, 2, 3, 7};
        Arrays.sort(sort);
        System.out.println(Arrays.toString(sort));
    }

    @Test
    public void func1() {
        int n=44;
        int p=1,q=2,t=0;
        for(int i=2;i<n;i++){
            t=p+q;
            p=q;
            q=t;
        }
        System.out.println(t);
    }

    @Test
    public void func2() {
        String s="leetcode";
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");

        System.out.println(s.matches("leet"));
        System.out.println(s.matches("code"));
        System.out.println(null==null);

        Map<Integer, Integer> map = new HashMap<>();
    }


}
