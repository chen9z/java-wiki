package wiki.test;

import wiki.thk.RecallProblem;
import org.junit.Test;

public class ThkTest {

    @Test
    public void func1() {
        RecallProblem recallProblem = new RecallProblem();
        recallProblem.cal8Queens(0);
    }
}
