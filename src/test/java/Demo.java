import alg.Practice;
import alg.sort.QuickSort;
import alg.sort.SortDemo;
import org.junit.Test;

import java.util.Arrays;

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

        String ss = "3010100\n" +
                "3010101\n" +
                "3010102\n" +
                "3010103\n" +
                "3010104\n" +
                "3010105\n" +
                "3010106\n" +
                "3010107\n" +
                "3010108\n" +
                "3010109\n";
        System.out.println(String.join(",",ss.split("\\n")));
    }

}
