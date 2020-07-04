package wiki.test;

import org.junit.Test;
import wiki.thk.RecallProblem;

public class ThkTest {

    @Test
    public void func1() {
        RecallProblem recallProblem = new RecallProblem();
        recallProblem.cal8Queens(0);
    }
}
