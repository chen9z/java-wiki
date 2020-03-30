import alg.Practice;
import alg.thk.NQueenProblem;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
        NQueenProblem nQueenProblem = new NQueenProblem();
        nQueenProblem.solveNQ();
    }
}
