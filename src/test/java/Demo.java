import alg.Practice;
import alg.sort.QuickSort;
import org.junit.Test;

import java.util.Arrays;

public class Demo {


    @Test
    public void func1() {
        String ss = "134134124";
        System.out.println(ss.contains("134"));
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
}
